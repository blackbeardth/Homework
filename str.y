%{
#include "lex.yy.c"
int valid=1;
%}
%token A B
%%
start: A start B
	 |
	 ;
%%
int yyerror() {
	valid=0;
	printf("Error");
	return 0;
}

int main() {
	printf("Enter Pattern: ");
	yyparse();
	if(valid) {
		printf("Valid Input!");
	}
}