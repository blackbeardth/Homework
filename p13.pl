% program to implement two predicates eveblength(List) and
% oddlength(List) so that they are true if their argument is a list of
% even or odd length respectively.

writeEven:- write("List is Even lengthed").
writeOdd:- write("List is Odd lengthed").

len([], 0).
len([_|T],R):- len(T,R1), R is R1+1.
evenLength(L):- len(L,R), Rmod2 is mod(R,2), Rmod2=:=0, writeEven.
oddLength(L):- len(L,R), Rmod2 is mod(R,2), Rmod2=\=0, writeOdd.
