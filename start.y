%{
	#include "lex.yy.c"
	int yylex(void);
	int yyerror(char *);
%}

%token D L
%%
S : L D { printf("Valid identifier\n"); }
  ;
%%
int main()
{
	yyparse();
	return 0;
}
int yyerror(char *msg)
{
	printf("Invalid identifier\n");
}