% program to implement delete+nth(N,L,R) that removes the element on Nth
% position form a list L to generate a list R.

delete(1,[_|T],T).
delete(N,[H|T],[H|R]):- N>=1, N1 is N-1, delete(N1,T,R).
