% program to implement nth_element(N,L,X) where N is the desired
% position, L is a list and X represents the Nth element of L.

nElement(1,[H|_],H).
nElement(N,[_|T],X):- N1 is N-1, nElement(N1,T,X).
