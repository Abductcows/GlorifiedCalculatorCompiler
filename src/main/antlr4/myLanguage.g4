grammar myLanguage;

/*
    Parser rules
*/

program: 'mainclass' ID '{' 'public' 'static' 'void' 'main' '(' ')' comp_stmt '}';

comp_stmt: '{' stmt+ '}';

stmt:     assign_stmt
          | for_stmt
          | while_stmt
          | if_stmt
          | comp_stmt
          | declaration
          | null_stmt
          | println_stmt
          ;

declaration: type ID (',' ID)* ';';

type:     'int' # TypeInt
          | 'float' # TypeFloat
          ;

null_stmt: ';';

println_stmt : 'println' '(' expr ')' ';';

assign_stmt: assign_expr ';';

assign_expr: ID '=' expr;

bool_expr: expr c_op expr;

expr:     assign_expr
          | rval
          ;

for_stmt: 'for' '(' opassign_expr';' opbool_expr';' opassign_expr ')' stmt;

opassign_expr:    assign_expr
                  |
                  ;

opbool_expr:  bool_expr # OpBoolPresent
              | # OpBoolAbsent
              ;

while_stmt: 'while' '(' bool_expr ')' stmt;

if_stmt: 'if' '(' bool_expr ')' stmt # PlainIf
         | 'if' '(' bool_expr ')' stmt 'else' stmt # IfElse
         ;


c_op:     '=='
          | '<'
          | '<='
          | '>'
          | '>='
          | '!='
          ;

rval:     term   # RvalTerm
          | rval '+' term # RvalPlus
          | rval '-' term # RvalMinus
          ;

term:     factor # TermFactor
          | term '*' factor # TermMultFactor
          | term '/' factor # TermDivFactor
          ;

factor:   '(' expr ')' # FactorExpr
          | '-' factor # FactorNegative
          | ID  # FactorID
          | INT # FactorInt
          | FLOAT # FactorFloat
          ;

/*
    Lexer rules
*/


fragment DIGIT  : [0-9];
fragment LETTER : [A-Za-z];

ID: LETTER (LETTER | DIGIT | '_')*;
INT: '0' | [1-9] DIGIT*;
FLOAT: INT '.' DIGIT*;

WS : [ \t\r\n]+ -> skip;
