%option noyywrap

%{
	#include "y.tab.h"
%}

%%
[a-zA-Z]+ {return ID;}
[0-9]+ {return NUM;}
. {return yytext[0];}
\n {return 0;}
%%