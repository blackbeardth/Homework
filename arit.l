%option noyywrap

%{
	#include<stdio.h>
	int opcount, idcount;
	int openb = 0, closeb = 0;
%}

op [+\-\*]
id [0-9a-zA-Z]+

%%
{op} {opcount++;}
{id} {idcount++;}
"{"|"("|"[" {openb++;}
"}"|")"|"[" {closeb++;}
%%

int main() {
	printf("Enter expression: ");
	yylex();
	if (openb == closeb && idcount > opcount)
		printf("valid arithmetic expression\n");
	else
		printf("invalid arithmetic expression\n");

	return 0;
}