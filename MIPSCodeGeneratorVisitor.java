import a4out.myLanguageBaseVisitor;
import a4out.myLanguageParser;
import utilities.*;
import utilities.SymbolTable.VariableInfo;
import utilities.SymbolTable.Types;

/**
 * Visitor class used for the traversal of the parse tree and generation of MIPS instructions. This class uses objects
 * of the "classes" package for utilities as well as for writing to the files.
 */
public class MIPSCodeGeneratorVisitor extends myLanguageBaseVisitor<VariableInfo> {

  private final MIPSInstructionsHelper helper;
  private final MIPSLabelTracker labels;
  private final MIPSStackTracker stackTracker;
  private final MIPSWriter writer;
  private final SymbolTable symbolTable;

  /**
   * Passes the String argument to the MIPSWriter object constructor to specify the name of the .asm output file and
   * initialises all other fields
   * @param outputFileName  desired file output name
   */
  public MIPSCodeGeneratorVisitor(String outputFileName) {
    super();
    helper = new MIPSInstructionsHelper();
    labels = new MIPSLabelTracker();
    stackTracker = new MIPSStackTracker();
    writer = new MIPSWriter(outputFileName);
    symbolTable = new SymbolTable();
  }

  /**
   * Creates the .asm files, adds boilerplate instructions, visits children and merges the temporary files in the end
   */
  @Override
  public VariableInfo visitProgram(myLanguageParser.ProgramContext ctx) {
    // Create files
    writer.initialiseFiles();
    // Data initialisation
    writer.appendData("_newLine: .asciiz \"\\n\"");
    writer.appendData(MyLanguageNumbersHelper.getArithmeticErrorMessageDeclarations());
    writer.appendData(stackTracker.getStackDeclarations());
    writer.appendData(MyLanguageNumbersHelper.getPrimitiveConstraintDeclarations());
    // One time initialisation instructions
    writer.appendText(stackTracker.getStackInit());
    writer.appendText("j main\n");
    // Float exception code
    writer.appendText(MyLanguageNumbersHelper.getNumericExceptionInstructions());
    // Float underflow/overflow check subprogram
    writer.appendText(MyLanguageNumbersHelper.getFloatExceptionCheckSubprogram());
    // Int overflow subprogram
    writer.appendText(MyLanguageNumbersHelper.getIntOverflowCorrectionSubprogram());
    // Program start
    writer.appendText("\n\nmain:");

    try {
      // visit statements
      super.visitProgram(ctx);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      declareVariables(symbolTable);
      // write program exit
      write(helper.getProgramExit());
      // create the final file
      writer.mergeFiles();
    }

    return null;
  }

  /**
   * Visits all statements
   * @return  null
   */
  @Override
  public VariableInfo visitComp_stmt(myLanguageParser.Comp_stmtContext ctx) {
    for(int i=1; i<ctx.getChildCount()-1; i++) {
      visit(ctx.getChild(i));
    }
    return null;
  }

  /**
   * Checks the declaration type and inserts all the non-declared symbols into the symbol table. Throws exception in
   * case of multiple declarations of the same id
   * @return  null, as it is a statement
   */
  @SuppressWarnings("DuplicateBranchesInSwitch")
  @Override
  public VariableInfo visitDeclaration(myLanguageParser.DeclarationContext ctx) {
    Types decType;

    switch (ctx.getChild(0).getText()) {
      case "int":
        decType = Types.INT;
        break;
      case "float":
        decType = Types.FLOAT;
        break;
      default:
        decType = Types.INT;
    }

    // check all IDs
    int i=1; // index of first ID
    while(ctx.getChild(i) != null) {
      String id = ctx.getChild(i).getText();
      if (symbolTable.get(id) == null) {
        switch (decType) {
          case INT:
            symbolTable.insert(id, 0);
            break;
          case FLOAT:
            symbolTable.insert(id, 0.0F);
        }
      } else {
        throw new RuntimeException("Variable \"" + id + "\"" + " already defined");
      }
      i+=2; // skip the ','
    }

    return null;
  }

  /**
   * Evaluates the parameter expression and calls the corresponding print instruction based on the static type of the
   * argument. Prints a newline character at the end
   * @return null, as it is a statement
   */
  @Override
  public VariableInfo visitPrintln_stmt(myLanguageParser.Println_stmtContext ctx) {
    // Visit expr to evaluate
    VariableInfo argumentInfo = visit(ctx.getChild(2));

    // Generate appropriate print code
    switch (argumentInfo.getType()) {
      case INT:
        write("li $v0 1");
        stackTracker.registerIntStackPop();
        write(helper.getIntStackTopAndPop("$a0"));
        break;
      case FLOAT:
        write("li $v0 3");
        stackTracker.registerFloatStackPop();
        write(helper.getFloatStackTopAndPop("$f12"));
        break;
    }
    write("syscall");
    // Print newline
    write("li $v0, 4");
    write("la $a0, _newLine");
    write("syscall");

    return null;
  }

  /**
   * Visits the expression and resets the stacks at the end as assignment expression values can be left in the stack
   * @return  null, as it is a statement
   */
  @Override
  public VariableInfo visitAssign_stmt(myLanguageParser.Assign_stmtContext ctx) {
    // visit first assign expression
    visit(ctx.getChild(0));
    // reset stacks in the event a value was not used
    write(helper.resetIntStack());
    write(helper.resetFloatStack());
    return null;
  }

  /**
   * Behaves like an assign statement
   * @return  null
   */
  @Override
  public VariableInfo visitOpassign_expr(myLanguageParser.Opassign_exprContext ctx) {
    super.visitOpassign_expr(ctx);
    write(helper.resetIntStack());
    write(helper.resetFloatStack());
    return null;
  }

  /**
   * Checks for declaration of the ID and evaluates the right hand expression. Preforms necessary widening or narrowing
   * of the value and stores it into the variable
   * @return  static type of the expression
   */
  @Override
  public VariableInfo visitAssign_expr(myLanguageParser.Assign_exprContext ctx) {
    String id = ctx.getChild(0).getText();
    // check if variable has been declared
    VariableInfo var1 = symbolTable.get(id);
    if (var1 == null) {
      throw new RuntimeException("Variable \"" + id + "\"" + " referenced but not previously defined");
    }

    // evaluate right hand expression and get its type
    VariableInfo exprInfo = visit(ctx.getChild(2));

    switch (var1.getType()) {
      case INT:
        // Load the expr value from stack and convert if necessary
        switch (exprInfo.getType()) {
          case INT:
            stackTracker.registerIntStackPop();
            write(helper.getIntStackTopAndPop("$t0"));
            break;
          case FLOAT:
            // get float value
            stackTracker.registerFloatStackPop();
            write(helper.getFloatStackTopAndPop("$f4"));
            // convert to int
            write(helper.floatToInt("$f4", "$f4"));
            write("mfc1.d $t0, $f4");
        }
        // check for overflow
        write("move $a0, $t0");
        write("jal _intOverflowCheck");
        write("move $t0, $v0");
        // store the value in the variable
        write("sw $t0, " + id);
        stackTracker.registerIntStackPush();
        // push expression value to the stack
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT:
        switch (exprInfo.getType()) {
          case INT:
            // load int from stack
            stackTracker.registerIntStackPop();
            write(helper.getIntStackTopAndPop("$t0"));
            // convert to "float"
            write("mtc1.d $t0, $f4");
            write(helper.intToFloat("$f4", "$f4"));
            break;
          case FLOAT:
            stackTracker.registerFloatStackPop();
            write(helper.getFloatStackTopAndPop("$f4"));
        }
        // store value in variable
        write("s.d $f4, " + id);
        // push expression value to the stack
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f4"));
        break;
    }
    // return the expression type (variable type)
    return var1;
  }

  /**
   * Evaluates left and right expressions and converts them to the wider type if conversion is possible, then preforms
   * comparison and stores the result in the boolean stack
   * @return  integer type
   */
  @Override
  public VariableInfo visitBool_expr(myLanguageParser.Bool_exprContext ctx) {
    VariableInfo var1 = visit(ctx.getChild(0));
    VariableInfo var2 = visit(ctx.getChild(2));

    Types prevalentType = Types.getWiderType(var1.getType(), var2.getType());
    convertVariablesAndStore(var1.getType(), var2.getType());

    String c_op = ctx.getChild(1).getText();
    String branchInstruction;
    labels.pushNextAfterIf();

    switch (prevalentType) {
      case INT: // both operands are of int type
        branchInstruction = MIPSInstructionsHelper.intBranches.get(c_op);
        branchInstruction += String.format(" $t0, $t1, %s", labels.getElse());
        break;
      case FLOAT: // at least one is float
        switch (c_op) {
          case "==":
            write("c.eq.d $f4, $f6");
            branchInstruction = "bc1f " + labels.getElse();
            break;
          case "<":
            write("c.lt.d $f4, $f6");
            branchInstruction = "bc1f " + labels.getElse();
            break;
          case "<=":
            write("c.le.d $f4, $f6");
            branchInstruction = "bc1f " + labels.getElse();
            break;
          case ">":
            write("c.le.d $f4, $f6");
            branchInstruction = "bc1t " + labels.getElse();
            break;
          case ">=":
            write("c.lt.d $f4, $f6");
            branchInstruction = "bc1t " + labels.getElse();
            break;
          case "!=":
            write("c.eq.d $f4, $f6");
            branchInstruction = "bc1t " + labels.getElse();
            break;
          default:
            branchInstruction = "";
        }
        break;
      default:
        branchInstruction = "";
    }
    write(branchInstruction);
    // Depending on the result of the comparison, store 1 or 0 to the boolean stack

    // (if instructions part) push 1 to bool stack
    write("li $t3, 1");
    stackTracker.registerBoolStackPush();
    write(helper.pushBoolStack("$t3"));
    // exit if
    write("j " + labels.getAfterIf());
    // else label
    write(labels.getElseLabel());
    // (else instructions part) push 0 to bool stack
    write(helper.pushBoolStack("$zero"));
    // afterIf label
    write(labels.getAfterIfLabel());
    labels.popAfterIf();

    return new VariableInfo(1);
  }

  /**
   * Executed when "for" boolean expression is omitted. Evaluates to true
   * @return  int type
   */
  @Override
  public VariableInfo visitOpBoolAbsent(myLanguageParser.OpBoolAbsentContext ctx) {
    // push positive value to the bool stack
    write("li $t0, 1");
    stackTracker.registerBoolStackPush();
    write(helper.pushBoolStack("$t0"));
    return new VariableInfo(1);
  }

  /**
   * Evaluates boolean expression and adds code for the branch statement. Then, visits child statements and appends the
   * rest of the required labels
   * @return  null, as it is a statement
   */
  @Override
  public VariableInfo visitPlainIf(myLanguageParser.PlainIfContext ctx) {
    // evaluate bool expr
    visit(ctx.getChild(2));
    // write branch condition
    labels.pushNextAfterIf();
    stackTracker.registerBoolStackPop();
    write(helper.getBoolStackTopAndPop("$t0"));
    write(String.format("beq $t0, 0, %s", labels.getAfterIf()));
    // visit statements
    visit(ctx.getChild(4));
    // close if statement
    write(labels.getAfterIfLabel());
    labels.popAfterIf();

    return null;
  }

  /**
   * Similar to the plain "if" visitor, but appends else label and instructions in between
   * @return  null, as it is a statement
   */
  @Override
  public VariableInfo visitIfElse(myLanguageParser.IfElseContext ctx) {
    // evaluate bool expr
    visit(ctx.getChild(2));
    labels.pushNextAfterIf();
    // write branch condition
    stackTracker.registerBoolStackPop();
    write(helper.getBoolStackTopAndPop("$t0"));
    write(String.format("beq $t0, 0, %s", labels.getElse()));
    // visit if statements
    visit(ctx.getChild(4));
    // jump to afterIf
    write("j " + labels.getAfterIf());
    // else label
    write(labels.getElseLabel());
    // else statements
    visit(ctx.getChild(6));
    // afterIf label
    write(labels.getAfterIfLabel());
    labels.popAfterIf();

    return null;
  }

  /**
   * Evaluates boolean expression and writes the while labels and branch instruction, visits statements and appends
   * loop jump instruction and exit loop label.
   * @return  null, as it is a statement
   */
  @Override
  public VariableInfo visitWhile_stmt(myLanguageParser.While_stmtContext ctx) {

    // write while label
    labels.pushNextWhile();
    write(labels.getWhileLabel());

    // evaluate boolean expression
    visit(ctx.getChild(2));

    // write branch condition
    stackTracker.registerBoolStackPop();
    write(helper.getBoolStackTopAndPop("$t0"));
    write("beq $t0, 0, " + labels.getAfterWhile());

    // visit while statements
    visit(ctx.getChild(4));

    // write loop jump
    write("j " + labels.getWhile());

    // write while exit label
    write(labels.getAfterWhileLabel());
    labels.popWhile();
    return null;
  }

  /**
   * For statement is treated as a while statement with an added assignment before it and a statement being executed
   * before the jump to complete the loop.
   * @return  null, as it is a statement
   */
  @Override
  public VariableInfo visitFor_stmt(myLanguageParser.For_stmtContext ctx) {
    // visit declaration first
    visit(ctx.getChild(2));

    // write while label
    labels.pushNextWhile();
    write(labels.getWhileLabel());

    // evaluate boolean expression
    visit(ctx.getChild(4));

    // write branch condition
    stackTracker.registerBoolStackPop();
    write(helper.getBoolStackTopAndPop("$t0"));
    write("beq $t0, 0, " + labels.getAfterWhile());

    // visit while statements
    visit(ctx.getChild(8));

    // visit third statement in the parentheses
    visit(ctx.getChild(6));

    // write loop jump
    write("j " + labels.getWhile());

    // write while exit label
    write(labels.getAfterWhileLabel());
    labels.popWhile();
    return null;
  }

  /**
   * Evaluates left and right expressions and converts them to the wider type if conversion is possible, then preforms
   * addition and stores the result in the appropriate stack
   * @return  Static type of the expression
   */
  @Override
  public VariableInfo visitRvalPlus(myLanguageParser.RvalPlusContext ctx) {
    // visit operand expressions and get their type
    VariableInfo var1 = visit(ctx.getChild(0));
    VariableInfo var2 = visit(ctx.getChild(2));

    Types resultType = Types.getWiderType(var1.getType(), var2.getType());
    convertVariablesAndStore(var1.getType(), var2.getType());

    switch (resultType) {
      case INT: // both values are int type
        // preform integer addition and push to int stack
        write("add $t0, $t0, $t1");
        stackTracker.registerIntStackPush();
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT: // at least one is float
        // preform floating point addition
        write("add.d $f4, $f4, $f6");
        // save value
        write("mov.d $f20, $f4");
        // check for float overflow/underflow
        write("mfc1.d $a0, $f20");
        write("jal _floatOverflowCheck");
        // push to stack
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f20"));
    }

    return resultType == Types.INT? new VariableInfo(1) : new VariableInfo(1.5F);
  }

  /**
   * Evaluates left and right expressions and converts them to the wider type if conversion is possible, then preforms
   * subtraction and stores the result in the appropriate stack
   * @return  Static type of the expression
   */
  @Override
  public VariableInfo visitRvalMinus(myLanguageParser.RvalMinusContext ctx) {
    // visit operand expressions and get their type
    VariableInfo var1 = visit(ctx.getChild(0));
    VariableInfo var2 = visit(ctx.getChild(2));

    Types resultType = Types.getWiderType(var1.getType(), var2.getType());
    convertVariablesAndStore(var1.getType(), var2.getType());

    switch (resultType) {

      case INT: // both values are int type
        // preform integer subtraction
        write("sub $t0, $t0, $t1");
        stackTracker.registerIntStackPush();
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT: // at least one is float
        // preform floating point subtraction
        write("sub.d $f4, $f4, $f6");
        // save value
        write("mov.d $f20, $f4");
        // check for float overflow/underflow
        write("mfc1.d $a0, $f20");
        write("jal _floatOverflowCheck");
        // push to stack
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f20"));
        break;
    }

    return resultType == Types.INT? new VariableInfo(1) : new VariableInfo(1.5F);
  }

  /**
   * Evaluates left and right expressions and converts them to the wider type if conversion is possible, then preforms
   * multiplication and stores the result in the appropriate stack
   * @return  Static type of the expression
   */
  @Override
  public VariableInfo visitTermMultFactor(myLanguageParser.TermMultFactorContext ctx) {
    // visit operand expressions and get their type
    VariableInfo var1 = visit(ctx.getChild(0));
    VariableInfo var2 = visit(ctx.getChild(2));

    Types resultType = Types.getWiderType(var1.getType(), var2.getType());
    convertVariablesAndStore(var1.getType(), var2.getType());

    switch (resultType) {
      case INT: // both values are of int type
        // preform int multiplication
        write("mult $t0, $t1");
        write("mflo $t0");
        // push result to int stack
        stackTracker.registerIntStackPush();
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT: // at least one operand is of float type
        // preform floating point multiplication and push to float stack
        write("mul.d $f4, $f4, $f6");
        // save value
        write("mov.d $f20, $f4");
        // check for float overflow/underflow
        write("mfc1.d $a0, $f20");
        write("jal _floatOverflowCheck");
        // push to float stack
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f20"));
        break;
    }

    return resultType == Types.INT? new VariableInfo(1) : new VariableInfo(1.5F);
  }

  /**
   * Evaluates left and right expressions and converts them to the wider type if conversion is possible, then preforms
   * division and stores the result in the appropriate stack
   * @return  Static type of the expression
   */
  @Override
  public VariableInfo visitTermDivFactor(myLanguageParser.TermDivFactorContext ctx) {
    // visit operand expressions and get their type
    VariableInfo var1 = visit(ctx.getChild(0));
    VariableInfo var2 = visit(ctx.getChild(2));

    Types resultType = Types.getWiderType(var1.getType(), var2.getType());
    convertVariablesAndStore(var1.getType(), var2.getType());

    switch (resultType) {
      case INT: // both operands are of int type
        // check for division by zero
        write("beq $zero, $t1, _divByZero");
        // preform integer division and push to int stack
        write("div $t0, $t1");
        write("mflo $t0");
        stackTracker.registerIntStackPush();
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT: // at least one operand is of float type
        // check for division by zero
        write("mtc1 $zero, $f8\n" +
            "cvt.d.w $f8, $f8\n" +
            "c.eq.d $f6, $f8\n" +
            "bc1t _divByZero");
        // preform floating point division
        write("div.d $f4, $f4, $f6");
        // save value
        write("mov.d $f20, $f4");
        // check for float overflow/underflow
        write("mfc1.d $a0, $f20");
        write("jal _floatOverflowCheck");
        // push to float stack
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f20"));
    }

    // return static type of the expression
    return resultType == Types.INT? new VariableInfo(1) : new VariableInfo(1.5F);
  }

  /**
   * Visits expression within the parentheses
   * @return  static type of the expression
   */
  @Override
  public VariableInfo visitFactorExpr(myLanguageParser.FactorExprContext ctx) {
    return visit(ctx.getChild(1));
  }

  /**
   * Negates the value of the last expression depending on argument type and pushes it to the stack
   * @return  static type of the expression
   */
  @Override
  public VariableInfo visitFactorNegative(myLanguageParser.FactorNegativeContext ctx) {
    // visit expression and get its type
    VariableInfo var1 = visit(ctx.getChild(1));

    // negate depending on type
    switch (var1.getType()) {
      case INT:
        // get operand from int stack
        stackTracker.registerIntStackPop();
        write(helper.getIntStackTopAndPop("$t0"));
        // negate
        write("subu $t0, $zero, $t0");
        stackTracker.registerIntStackPush();
        // push result to stack
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT:
        // get operand from float stack
        stackTracker.registerFloatStackPop();
        write(helper.getFloatStackTopAndPop("$f4"));
        // negate
        write("neg.d $f4, $f4");
        // push to float stack
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f4"));
    }

    // return type of the expression
    return var1;
  }

  /**
   * Checks the symbol table for declaration of the id and pushes its value to the appropriate stack depending on
   * its type
   *
   * @return  VariableInfo object of the variable corresponding to the ID
   */
  @Override
  public VariableInfo visitFactorID(myLanguageParser.FactorIDContext ctx) {
    String id = ctx.getText();
    if (symbolTable.get(id) == null) {
      throw new RuntimeException("Variable \"" + id + "\"" + " referenced but not previously defined");
    }

    VariableInfo info = symbolTable.get(id);

    // Load value and push to appropriate stack
    switch (info.getType()) {
      case INT:
        write("lw $t0, " + id);
        stackTracker.registerIntStackPush();
        write(helper.pushIntStack("$t0"));
        break;
      case FLOAT:
        write("l.d $f4, " + id);
        stackTracker.registerFloatStackPush();
        write(helper.pushFloatStack("$f4"));
    }

    return info;
  }

  /**
   * Generates MIPS load immediate code for the int literal, pushes it to the int stack and returns the expression's
   * static type (INT)
   *
   * @return  VariableInfo object containing the Types.INT type
   */
  @Override
  public VariableInfo visitFactorInt(myLanguageParser.FactorIntContext ctx) {
    // load immediate int literal and push to int stack
    write("li $t0, " + ctx.getText());
    stackTracker.registerIntStackPush();
    write(helper.pushIntStack("$t0"));
    return new VariableInfo(Integer.parseInt(ctx.getText()));
  }

  /**
   * Generates MIPS declaration code for the float literal, pushes it to the float stack and returns the expression's
   * static type (FLOAT)
   *
   * @return  VariableInfo object containing the Types.FLOAT type
   */
  @Override
  public VariableInfo visitFactorFloat(myLanguageParser.FactorFloatContext ctx) {
    // declare new float literal
    writer.appendData(labels.getNextFloatLiteralDeclaration(ctx.getText()));
    // load float value and push to flaot stack
    write("l.d $f4, " + labels.getCurrentFloatLiteral());
    stackTracker.registerFloatStackPush();
    write(helper.pushFloatStack("$f4"));
    return new VariableInfo(Float.parseFloat(ctx.getText()));
  }

  /**
   * Utility method that reuses code for when two number operands are involved. Depending on the types of the arguments,
   * the method writes code for popping from the appropriate stack and storing in the appropriate registers for the
   * values to be used immediately afterwards. Any necessary conversions are preformed and the values are stored in
   * $t0 and $t1 for the case of two integer values and $f4 and $f6 otherwise
   * @param t1  Static type of operand 1
   * @param t2  Static type of operand 2
   */
  private void convertVariablesAndStore(Types t1, Types t2) {
    if (t1 == Types.INT && t2 == Types.INT) {
      stackTracker.registerIntStackPop();
      stackTracker.registerIntStackPop();
      write(helper.getIntStackTopAndPop("$t1")); // op2
      write(helper.getIntStackTopAndPop("$t0")); // op1
    } else if (t1 == Types.INT) {
      // op1 is int, convert and store
      stackTracker.registerIntStackPop();
      write(helper.getIntStackTopAndPop("$t0"));
      write("mtc1 $t0, $f4");
      write(helper.intToFloat("$f4", "$f4"));
      // op2 is float, store immediately
      stackTracker.registerFloatStackPop();
      write(helper.getFloatStackTopAndPop("$f6"));
    } else if (t2 == Types.INT){
      // op1 is float, store immediately
      stackTracker.registerFloatStackPop();
      write(helper.getFloatStackTopAndPop("$f4"));
      // op2 is int, convert and store
      stackTracker.registerIntStackPop();
      write(helper.getIntStackTopAndPop("$t0"));
      write("mtc1 $t0, $f6");
      write(helper.intToFloat("$f6", "$f6"));
    } else { // both are of type float
      stackTracker.registerFloatStackPop();
      stackTracker.registerFloatStackPop();
      write(helper.getFloatStackTopAndPop("$f6")); // op2
      write(helper.getFloatStackTopAndPop("$f4")); // op1
    }
  }

  /**
   * Alias for calling the writer.appendText() method in order to reduce line width
   * @param s  String of instruction to be appended to the text temp file (no newline)
   */
  private void write(String s) {
    writer.appendText(s);
  }

  /**
   * Declares every variable in the symbol table at the data section. Type and value are recovered from the symbol table
   * @param table  symbolTable from which declarations are to be imported
   */
  public void declareVariables(SymbolTable table)  {
    for (String id : table.getIDs()) {

      VariableInfo info = table.get(id);
      switch (info.getType()) {
        case INT:
          writer.appendData(String.format("%s: .align 2\n.word %d", id, info.getIntVal()));
          break;
        case FLOAT:
          writer.appendData(String.format("%s: .align 3\n.double %f", id, info.getFloatVal()));
      }
    }
  }

}
