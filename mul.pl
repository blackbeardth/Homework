% program to implement multi(N1, N2, R) where N1 and N2 denotes the
% numbers to be multiplied and R represents the result.

multi(X, 0).
multi(N1, N2, R):- R is N1 * N2.
