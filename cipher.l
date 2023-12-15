%option noyywrap

%%
[a-w A-W] { printf("%c", yytext[0] + 3); }
[xyzXYZ] { printf("%c", yytext[0] - 23); }
%%

int main() {
	yylex();
	
	return 0;
}