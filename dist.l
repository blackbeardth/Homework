%option noyywrap

%%
[#].* {printf("preprocessor directive\n"); }
[0-9]+ {printf("Integer\n");}
[0-9]+\.[0-9]+ {printf("Float\n");}
int|float|char|if|else|for|printf|switch|main {printf("Keyword\n");}
[A-Za-z_][A-Za-z0-9_]* {printf("Identifier\n");}
["+"|"*"|"/"|"="|"<"|">"|"!"|"&"|"|"|"-"] {printf("Operator\n");}
"//".* {printf("Comment\n");}

%%

int main() {
   yylex();
   return 0;
}
