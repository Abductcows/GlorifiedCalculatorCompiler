import a4out.myLanguageLexer;
import a4out.myLanguageParser;
import classes.SymbolTable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.io.IOException;

/**
 * Main class of the compiler. Initialises antlr lexer, parser and visitor from filename argument and visits the
 * parse tree for code generation
 */
public class Compile {

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new RuntimeException("No source code files provided");
    } else if (args.length == 3 && args[1].equals("-o")) {
      // compile with custom output file name
      compile(args[0], args[2]);
    } else {
      // compile all files
      for (String filename : args) {
        compile(filename, filename);
      }
    }
  }

  /**
   * Antlr start method
   * @param filename  compile target file name
   * @param outputName  output file name
   */
  private static void compile(String filename, String outputName) throws IOException {
    myLanguageLexer lexer = new myLanguageLexer(CharStreams.fromFileName(filename));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    myLanguageParser parser = new myLanguageParser(tokens);
    ParseTree tree = parser.program(); // Start at the first rule

    ParseTreeVisitor<SymbolTable.VariableInfo> visitor = new MIPSCodeGeneratorVisitor(outputName);
    visitor.visit(tree);
  }

}
