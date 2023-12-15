%option noyywrap

%{
	int words = 0, characters = 0, lines = 0, spaces = 0;
%}

%%
[^ \t\n,\.:;]+ { words++; characters += yyleng; }
[\n] { lines++; characters += yyleng; }
[ |\t] { spaces++; characters += yyleng; }
. { characters++; }
%%

int main() {
	yyin=fopen("text.c", "r");
	yylex();
	printf("\nNo. of words: %d\n", words);
	printf("No. of characters: %d\n", characters);
	printf("No. of lines: %d\n", lines);
	printf("No. of spaces: %d\n", spaces);

	return 0;
}