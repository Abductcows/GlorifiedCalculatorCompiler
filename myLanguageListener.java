// Generated from /home/abductcows/Documents/Antlr4 Projects/myLanguage/myLanguage.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myLanguageParser}.
 */
public interface myLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(myLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(myLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#comp_stmt}.
	 * @param ctx the parse tree
	 */
	void enterComp_stmt(myLanguageParser.Comp_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#comp_stmt}.
	 * @param ctx the parse tree
	 */
	void exitComp_stmt(myLanguageParser.Comp_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(myLanguageParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(myLanguageParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(myLanguageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(myLanguageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link myLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(myLanguageParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link myLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(myLanguageParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeFloat}
	 * labeled alternative in {@link myLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeFloat(myLanguageParser.TypeFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeFloat}
	 * labeled alternative in {@link myLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeFloat(myLanguageParser.TypeFloatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#null_stmt}.
	 * @param ctx the parse tree
	 */
	void enterNull_stmt(myLanguageParser.Null_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#null_stmt}.
	 * @param ctx the parse tree
	 */
	void exitNull_stmt(myLanguageParser.Null_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#println_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintln_stmt(myLanguageParser.Println_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#println_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintln_stmt(myLanguageParser.Println_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(myLanguageParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(myLanguageParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(myLanguageParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(myLanguageParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(myLanguageParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(myLanguageParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(myLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(myLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(myLanguageParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(myLanguageParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#opassign_expr}.
	 * @param ctx the parse tree
	 */
	void enterOpassign_expr(myLanguageParser.Opassign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#opassign_expr}.
	 * @param ctx the parse tree
	 */
	void exitOpassign_expr(myLanguageParser.Opassign_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpBoolPresent}
	 * labeled alternative in {@link myLanguageParser#opbool_expr}.
	 * @param ctx the parse tree
	 */
	void enterOpBoolPresent(myLanguageParser.OpBoolPresentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpBoolPresent}
	 * labeled alternative in {@link myLanguageParser#opbool_expr}.
	 * @param ctx the parse tree
	 */
	void exitOpBoolPresent(myLanguageParser.OpBoolPresentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpBoolAbsent}
	 * labeled alternative in {@link myLanguageParser#opbool_expr}.
	 * @param ctx the parse tree
	 */
	void enterOpBoolAbsent(myLanguageParser.OpBoolAbsentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpBoolAbsent}
	 * labeled alternative in {@link myLanguageParser#opbool_expr}.
	 * @param ctx the parse tree
	 */
	void exitOpBoolAbsent(myLanguageParser.OpBoolAbsentContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(myLanguageParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(myLanguageParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlainIf}
	 * labeled alternative in {@link myLanguageParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPlainIf(myLanguageParser.PlainIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlainIf}
	 * labeled alternative in {@link myLanguageParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPlainIf(myLanguageParser.PlainIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link myLanguageParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(myLanguageParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link myLanguageParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(myLanguageParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link myLanguageParser#c_op}.
	 * @param ctx the parse tree
	 */
	void enterC_op(myLanguageParser.C_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link myLanguageParser#c_op}.
	 * @param ctx the parse tree
	 */
	void exitC_op(myLanguageParser.C_opContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RvalTerm}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 */
	void enterRvalTerm(myLanguageParser.RvalTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RvalTerm}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 */
	void exitRvalTerm(myLanguageParser.RvalTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RvalPlus}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 */
	void enterRvalPlus(myLanguageParser.RvalPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RvalPlus}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 */
	void exitRvalPlus(myLanguageParser.RvalPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RvalMinus}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 */
	void enterRvalMinus(myLanguageParser.RvalMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RvalMinus}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 */
	void exitRvalMinus(myLanguageParser.RvalMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermMultFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermMultFactor(myLanguageParser.TermMultFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermMultFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermMultFactor(myLanguageParser.TermMultFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermFactor(myLanguageParser.TermFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermFactor(myLanguageParser.TermFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermDivFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermDivFactor(myLanguageParser.TermDivFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermDivFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermDivFactor(myLanguageParser.TermDivFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorExpr}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpr(myLanguageParser.FactorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorExpr}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpr(myLanguageParser.FactorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorNegative}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorNegative(myLanguageParser.FactorNegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorNegative}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorNegative(myLanguageParser.FactorNegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorID}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorID(myLanguageParser.FactorIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorID}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorID(myLanguageParser.FactorIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorInt}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorInt(myLanguageParser.FactorIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorInt}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorInt(myLanguageParser.FactorIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorFloat}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorFloat(myLanguageParser.FactorFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorFloat}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorFloat(myLanguageParser.FactorFloatContext ctx);
}