%{
	#include "lex.yy.c"
	#include <stdio.h>
	#include <stdlib.h>
	void yyerror() {
		printf("\nInvalid\n");
	}
%}

%token ID NUM
%left '+' '-'
%left '*' '/'
%left '(' ')'

%%
	s:E {printf("\nValid\n");};
	E:E'+'E | E'-'E | E'*'E | E '/' E | '('E')' | NUM | ID;
%%

int main() {
	printf("\nEnter expression: ");
	yyparse();
	return 0;
}