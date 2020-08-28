package a4out;// Generated from /home/abductcows/Documents/Antlr4 Projects/myLanguage/myLanguage.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link myLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface myLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(myLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#comp_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_stmt(myLanguageParser.Comp_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(myLanguageParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(myLanguageParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link myLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(myLanguageParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeFloat}
	 * labeled alternative in {@link myLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFloat(myLanguageParser.TypeFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#null_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_stmt(myLanguageParser.Null_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#println_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln_stmt(myLanguageParser.Println_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(myLanguageParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#assign_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_expr(myLanguageParser.Assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#bool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_expr(myLanguageParser.Bool_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(myLanguageParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(myLanguageParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#opassign_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpassign_expr(myLanguageParser.Opassign_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpBoolPresent}
	 * labeled alternative in {@link myLanguageParser#opbool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpBoolPresent(myLanguageParser.OpBoolPresentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpBoolAbsent}
	 * labeled alternative in {@link myLanguageParser#opbool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpBoolAbsent(myLanguageParser.OpBoolAbsentContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(myLanguageParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlainIf}
	 * labeled alternative in {@link myLanguageParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainIf(myLanguageParser.PlainIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link myLanguageParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(myLanguageParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link myLanguageParser#c_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_op(myLanguageParser.C_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RvalTerm}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRvalTerm(myLanguageParser.RvalTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RvalPlus}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRvalPlus(myLanguageParser.RvalPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RvalMinus}
	 * labeled alternative in {@link myLanguageParser#rval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRvalMinus(myLanguageParser.RvalMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermMultFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermMultFactor(myLanguageParser.TermMultFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermFactor(myLanguageParser.TermFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermDivFactor}
	 * labeled alternative in {@link myLanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermDivFactor(myLanguageParser.TermDivFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorExpr}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorExpr(myLanguageParser.FactorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorNegative}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorNegative(myLanguageParser.FactorNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorID}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorID(myLanguageParser.FactorIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorInt}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorInt(myLanguageParser.FactorIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorFloat}
	 * labeled alternative in {@link myLanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorFloat(myLanguageParser.FactorFloatContext ctx);
}