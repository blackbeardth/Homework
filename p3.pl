% Program to implement factorail(N, F) where F represents the factorial
% of number N

fact(0, 1).
fact(N, X):-N1 is N - 1, fact(N1, Y), X is Y*N, !.
