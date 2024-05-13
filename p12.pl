% program to implement sumlist(L,S) so that S is sum of a given list L.

sumlist([],0).
sumlist([H|T],S):- sumlist(T,S1),S is S1+H.

