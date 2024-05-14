% Write a program in PROLOG to implement remove_dup (L, R) where L denotes the list with
% some duplicates and the list R denotes the list with duplicates
% removed.

member(X,[X|_]).
member(X,[_|Y]):- member(X,Y).
remove_dup(L,M):-dupacc(L,[],M).
dupacc([],A,A).
dupacc([H|T],A,L):-member(H,A),dupacc(T,A,L),!.
dupacc([H|T],A,L):-dupacc(T,[H|A],L).
