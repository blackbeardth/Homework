%option noyywrap
%{
	int id_count = 0;
	char ch;
%}

%%
"int"|"float"|"char"|"double" {
	ch = input();
	for(;;) {
		if (ch == ',')
			id_count++;
		else if(ch == ';')
			break;
		ch = input();
	}
	id_count++;
}
%%

int main(int argc, char **argv) {
	FILE *fp;
	fp = fopen(argv[1], "r");
	yyin = fp;
	yylex();
	printf("Total identifiers: %d\n", id_count);

	return 0;
}