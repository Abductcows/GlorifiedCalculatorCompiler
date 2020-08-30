// Generated from /home/abductcows/Documents/Antlr4 Projects/myLanguage/myLanguage.g4 by ANTLR 4.8
package a4out;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, ID=30, INT=31, FLOAT=32, 
		WS=33;
	public static final int
		RULE_program = 0, RULE_comp_stmt = 1, RULE_stmt = 2, RULE_declaration = 3, 
		RULE_type = 4, RULE_null_stmt = 5, RULE_println_stmt = 6, RULE_assign_stmt = 7, 
		RULE_assign_expr = 8, RULE_bool_expr = 9, RULE_expr = 10, RULE_for_stmt = 11, 
		RULE_opassign_expr = 12, RULE_opbool_expr = 13, RULE_while_stmt = 14, 
		RULE_if_stmt = 15, RULE_c_op = 16, RULE_rval = 17, RULE_term = 18, RULE_factor = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "comp_stmt", "stmt", "declaration", "type", "null_stmt", "println_stmt", 
			"assign_stmt", "assign_expr", "bool_expr", "expr", "for_stmt", "opassign_expr", 
			"opbool_expr", "while_stmt", "if_stmt", "c_op", "rval", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'mainclass'", "'{'", "'public'", "'static'", "'void'", "'main'", 
			"'('", "')'", "'}'", "','", "';'", "'int'", "'float'", "'println'", "'='", 
			"'for'", "'while'", "'if'", "'else'", "'=='", "'<'", "'<='", "'>'", "'>='", 
			"'!='", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "ID", "INT", "FLOAT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "myLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public myLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(myLanguageParser.ID, 0); }
		public Comp_stmtContext comp_stmt() {
			return getRuleContext(Comp_stmtContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			match(ID);
			setState(42);
			match(T__1);
			setState(43);
			match(T__2);
			setState(44);
			match(T__3);
			setState(45);
			match(T__4);
			setState(46);
			match(T__5);
			setState(47);
			match(T__6);
			setState(48);
			match(T__7);
			setState(49);
			comp_stmt();
			setState(50);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_stmtContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Comp_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterComp_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitComp_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitComp_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_stmtContext comp_stmt() throws RecognitionException {
		Comp_stmtContext _localctx = new Comp_stmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comp_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__1);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				stmt();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0) );
			setState(58);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Comp_stmtContext comp_stmt() {
			return getRuleContext(Comp_stmtContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Null_stmtContext null_stmt() {
			return getRuleContext(Null_stmtContext.class,0);
		}
		public Println_stmtContext println_stmt() {
			return getRuleContext(Println_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				assign_stmt();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				for_stmt();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				while_stmt();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				if_stmt();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				comp_stmt();
				}
				break;
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
				declaration();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				null_stmt();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 8);
				{
				setState(67);
				println_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(myLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(myLanguageParser.ID, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			type();
			setState(71);
			match(ID);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(72);
				match(T__9);
				setState(73);
				match(ID);
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeFloatContext extends TypeContext {
		public TypeFloatContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterTypeFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitTypeFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitTypeFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIntContext extends TypeContext {
		public TypeIntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitTypeInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new TypeFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_stmtContext extends ParserRuleContext {
		public Null_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterNull_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitNull_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitNull_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Null_stmtContext null_stmt() throws RecognitionException {
		Null_stmtContext _localctx = new Null_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_null_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Println_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Println_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterPrintln_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitPrintln_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitPrintln_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Println_stmtContext println_stmt() throws RecognitionException {
		Println_stmtContext _localctx = new Println_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_println_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__13);
			setState(88);
			match(T__6);
			setState(89);
			expr();
			setState(90);
			match(T__7);
			setState(91);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			assign_expr();
			setState(94);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(myLanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitAssign_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitAssign_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ID);
			setState(97);
			match(T__14);
			setState(98);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public C_opContext c_op() {
			return getRuleContext(C_opContext.class,0);
		}
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitBool_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bool_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			expr();
			setState(101);
			c_op();
			setState(102);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				assign_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				rval(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public List<Opassign_exprContext> opassign_expr() {
			return getRuleContexts(Opassign_exprContext.class);
		}
		public Opassign_exprContext opassign_expr(int i) {
			return getRuleContext(Opassign_exprContext.class,i);
		}
		public Opbool_exprContext opbool_expr() {
			return getRuleContext(Opbool_exprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__15);
			setState(109);
			match(T__6);
			setState(110);
			opassign_expr();
			setState(111);
			match(T__10);
			setState(112);
			opbool_expr();
			setState(113);
			match(T__10);
			setState(114);
			opassign_expr();
			setState(115);
			match(T__7);
			setState(116);
			stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opassign_exprContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Opassign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opassign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterOpassign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitOpassign_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitOpassign_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Opassign_exprContext opassign_expr() throws RecognitionException {
		Opassign_exprContext _localctx = new Opassign_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_opassign_expr);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				assign_expr();
				}
				break;
			case T__7:
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opbool_exprContext extends ParserRuleContext {
		public Opbool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opbool_expr; }
	 
		public Opbool_exprContext() { }
		public void copyFrom(Opbool_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpBoolPresentContext extends Opbool_exprContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public OpBoolPresentContext(Opbool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterOpBoolPresent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitOpBoolPresent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitOpBoolPresent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpBoolAbsentContext extends Opbool_exprContext {
		public OpBoolAbsentContext(Opbool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterOpBoolAbsent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitOpBoolAbsent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitOpBoolAbsent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Opbool_exprContext opbool_expr() throws RecognitionException {
		Opbool_exprContext _localctx = new Opbool_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_opbool_expr);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__26:
			case ID:
			case INT:
			case FLOAT:
				_localctx = new OpBoolPresentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				bool_expr();
				}
				break;
			case T__10:
				_localctx = new OpBoolAbsentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__16);
			setState(127);
			match(T__6);
			setState(128);
			bool_expr();
			setState(129);
			match(T__7);
			setState(130);
			stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	 
		public If_stmtContext() { }
		public void copyFrom(If_stmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlainIfContext extends If_stmtContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public PlainIfContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterPlainIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitPlainIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitPlainIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseContext extends If_stmtContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfElseContext(If_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_if_stmt);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new PlainIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T__17);
				setState(133);
				match(T__6);
				setState(134);
				bool_expr();
				setState(135);
				match(T__7);
				setState(136);
				stmt();
				}
				break;
			case 2:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(T__17);
				setState(139);
				match(T__6);
				setState(140);
				bool_expr();
				setState(141);
				match(T__7);
				setState(142);
				stmt();
				setState(143);
				match(T__18);
				setState(144);
				stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class C_opContext extends ParserRuleContext {
		public C_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterC_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitC_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitC_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final C_opContext c_op() throws RecognitionException {
		C_opContext _localctx = new C_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_c_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RvalContext extends ParserRuleContext {
		public RvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rval; }
	 
		public RvalContext() { }
		public void copyFrom(RvalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RvalTermContext extends RvalContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public RvalTermContext(RvalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterRvalTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitRvalTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitRvalTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RvalPlusContext extends RvalContext {
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public RvalPlusContext(RvalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterRvalPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitRvalPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitRvalPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RvalMinusContext extends RvalContext {
		public RvalContext rval() {
			return getRuleContext(RvalContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public RvalMinusContext(RvalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterRvalMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitRvalMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitRvalMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RvalContext rval() throws RecognitionException {
		return rval(0);
	}

	private RvalContext rval(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RvalContext _localctx = new RvalContext(_ctx, _parentState);
		RvalContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_rval, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RvalTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(151);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(159);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new RvalPlusContext(new RvalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rval);
						setState(153);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(154);
						match(T__25);
						setState(155);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new RvalMinusContext(new RvalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rval);
						setState(156);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(157);
						match(T__26);
						setState(158);
						term(0);
						}
						break;
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermMultFactorContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermMultFactorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterTermMultFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitTermMultFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitTermMultFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermFactorContext extends TermContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermFactorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterTermFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitTermFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitTermFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermDivFactorContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermDivFactorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterTermDivFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitTermDivFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitTermDivFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermFactorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(165);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(173);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new TermMultFactorContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(167);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(168);
						match(T__27);
						setState(169);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new TermDivFactorContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(170);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(171);
						match(T__28);
						setState(172);
						factor();
						}
						break;
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactorIntContext extends FactorContext {
		public TerminalNode INT() { return getToken(myLanguageParser.INT, 0); }
		public FactorIntContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterFactorInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitFactorInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitFactorInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorNegativeContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorNegativeContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterFactorNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitFactorNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitFactorNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorFloatContext extends FactorContext {
		public TerminalNode FLOAT() { return getToken(myLanguageParser.FLOAT, 0); }
		public FactorFloatContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterFactorFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitFactorFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitFactorFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorExprContext extends FactorContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactorExprContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterFactorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitFactorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitFactorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorIDContext extends FactorContext {
		public TerminalNode ID() { return getToken(myLanguageParser.ID, 0); }
		public FactorIDContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).enterFactorID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myLanguageListener ) ((myLanguageListener)listener).exitFactorID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myLanguageVisitor ) return ((myLanguageVisitor<? extends T>)visitor).visitFactorID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_factor);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new FactorExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(T__6);
				setState(179);
				expr();
				setState(180);
				match(T__7);
				}
				break;
			case T__26:
				_localctx = new FactorNegativeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(T__26);
				setState(183);
				factor();
				}
				break;
			case ID:
				_localctx = new FactorIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(ID);
				}
				break;
			case INT:
				_localctx = new FactorIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FactorFloatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				match(FLOAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return rval_sempred((RvalContext)_localctx, predIndex);
		case 18:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rval_sempred(RvalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00c0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\6\39\n\3\r\3\16\3:\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4G\n\4\3\5\3\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5\3\5\3\6\3"+
		"\6\5\6V\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\5\fm\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\5\16{\n\16\3\17\3\17\5\17\177\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0095\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u00a2\n\23\f\23\16\23\u00a5\13\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00b0\n\24\f\24\16\24\u00b3\13\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00be\n\25\3\25\2\4"+
		"$&\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\3\3\2\26\33\2\u00c1"+
		"\2*\3\2\2\2\4\66\3\2\2\2\6F\3\2\2\2\bH\3\2\2\2\nU\3\2\2\2\fW\3\2\2\2\16"+
		"Y\3\2\2\2\20_\3\2\2\2\22b\3\2\2\2\24f\3\2\2\2\26l\3\2\2\2\30n\3\2\2\2"+
		"\32z\3\2\2\2\34~\3\2\2\2\36\u0080\3\2\2\2 \u0094\3\2\2\2\"\u0096\3\2\2"+
		"\2$\u0098\3\2\2\2&\u00a6\3\2\2\2(\u00bd\3\2\2\2*+\7\3\2\2+,\7 \2\2,-\7"+
		"\4\2\2-.\7\5\2\2./\7\6\2\2/\60\7\7\2\2\60\61\7\b\2\2\61\62\7\t\2\2\62"+
		"\63\7\n\2\2\63\64\5\4\3\2\64\65\7\13\2\2\65\3\3\2\2\2\668\7\4\2\2\679"+
		"\5\6\4\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\13\2"+
		"\2=\5\3\2\2\2>G\5\20\t\2?G\5\30\r\2@G\5\36\20\2AG\5 \21\2BG\5\4\3\2CG"+
		"\5\b\5\2DG\5\f\7\2EG\5\16\b\2F>\3\2\2\2F?\3\2\2\2F@\3\2\2\2FA\3\2\2\2"+
		"FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2G\7\3\2\2\2HI\5\n\6\2IN\7 \2\2"+
		"JK\7\f\2\2KM\7 \2\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2"+
		"PN\3\2\2\2QR\7\r\2\2R\t\3\2\2\2SV\7\16\2\2TV\7\17\2\2US\3\2\2\2UT\3\2"+
		"\2\2V\13\3\2\2\2WX\7\r\2\2X\r\3\2\2\2YZ\7\20\2\2Z[\7\t\2\2[\\\5\26\f\2"+
		"\\]\7\n\2\2]^\7\r\2\2^\17\3\2\2\2_`\5\22\n\2`a\7\r\2\2a\21\3\2\2\2bc\7"+
		" \2\2cd\7\21\2\2de\5\26\f\2e\23\3\2\2\2fg\5\26\f\2gh\5\"\22\2hi\5\26\f"+
		"\2i\25\3\2\2\2jm\5\22\n\2km\5$\23\2lj\3\2\2\2lk\3\2\2\2m\27\3\2\2\2no"+
		"\7\22\2\2op\7\t\2\2pq\5\32\16\2qr\7\r\2\2rs\5\34\17\2st\7\r\2\2tu\5\32"+
		"\16\2uv\7\n\2\2vw\5\6\4\2w\31\3\2\2\2x{\5\22\n\2y{\3\2\2\2zx\3\2\2\2z"+
		"y\3\2\2\2{\33\3\2\2\2|\177\5\24\13\2}\177\3\2\2\2~|\3\2\2\2~}\3\2\2\2"+
		"\177\35\3\2\2\2\u0080\u0081\7\23\2\2\u0081\u0082\7\t\2\2\u0082\u0083\5"+
		"\24\13\2\u0083\u0084\7\n\2\2\u0084\u0085\5\6\4\2\u0085\37\3\2\2\2\u0086"+
		"\u0087\7\24\2\2\u0087\u0088\7\t\2\2\u0088\u0089\5\24\13\2\u0089\u008a"+
		"\7\n\2\2\u008a\u008b\5\6\4\2\u008b\u0095\3\2\2\2\u008c\u008d\7\24\2\2"+
		"\u008d\u008e\7\t\2\2\u008e\u008f\5\24\13\2\u008f\u0090\7\n\2\2\u0090\u0091"+
		"\5\6\4\2\u0091\u0092\7\25\2\2\u0092\u0093\5\6\4\2\u0093\u0095\3\2\2\2"+
		"\u0094\u0086\3\2\2\2\u0094\u008c\3\2\2\2\u0095!\3\2\2\2\u0096\u0097\t"+
		"\2\2\2\u0097#\3\2\2\2\u0098\u0099\b\23\1\2\u0099\u009a\5&\24\2\u009a\u00a3"+
		"\3\2\2\2\u009b\u009c\f\4\2\2\u009c\u009d\7\34\2\2\u009d\u00a2\5&\24\2"+
		"\u009e\u009f\f\3\2\2\u009f\u00a0\7\35\2\2\u00a0\u00a2\5&\24\2\u00a1\u009b"+
		"\3\2\2\2\u00a1\u009e\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4%\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\b\24\1\2"+
		"\u00a7\u00a8\5(\25\2\u00a8\u00b1\3\2\2\2\u00a9\u00aa\f\4\2\2\u00aa\u00ab"+
		"\7\36\2\2\u00ab\u00b0\5(\25\2\u00ac\u00ad\f\3\2\2\u00ad\u00ae\7\37\2\2"+
		"\u00ae\u00b0\5(\25\2\u00af\u00a9\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0\u00b3"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\'\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\7\t\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7\7"+
		"\n\2\2\u00b7\u00be\3\2\2\2\u00b8\u00b9\7\35\2\2\u00b9\u00be\5(\25\2\u00ba"+
		"\u00be\7 \2\2\u00bb\u00be\7!\2\2\u00bc\u00be\7\"\2\2\u00bd\u00b4\3\2\2"+
		"\2\u00bd\u00b8\3\2\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00be)\3\2\2\2\17:FNUlz~\u0094\u00a1\u00a3\u00af\u00b1\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}