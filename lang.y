%{
	#include "lex.yy.c"
	#include <stdio.h>
	#include <stdlib.h>	
%}

%token A B

%%
start:S
{
	printf("Valid\n");
	return 0;
}
S: A S B|A B;
%%
int yyerror() {
	printf("Invalid\n");
	return 0;
}

int main() {
	printf("Enter string: ");
	yyparse();
	return 1;
}