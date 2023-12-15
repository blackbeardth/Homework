%option noyywrap

%{
	int charcount = 0, linecount = 0;
%}

%%
. {
	charcount++;
}
\n {
	linecount++;
	charcount++;
}
%%

int main() {
	yyin = fopen("text.txt", "r");
	if(!yyin) {
		printf("Could not open file\n");
		return -1;
	}
	yylex();
	fclose(yyin);
	printf("There are %d characters and %d lines\n", charcount, linecount);
	
	return 0;
}