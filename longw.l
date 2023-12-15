%option noyywrap
%{
	#include<stdio.h>
	#include<string.h>
	int c = 0;
	char* l;
%}

%%
[a-zA-Z]+ { if(yyleng>c) {
	c = yyleng;
	l = (char*)realloc(l, yyleng+1);
	strcpy(l,yytext);
	}
}
%%
int main() {
	l = (char*)malloc(1);
	yylex();
	printf("longest word: %s", l);
	printf("\nlength: %d", c);
	printf("\n");
	
	return 0;
}