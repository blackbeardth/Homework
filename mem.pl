% program to implement memb(X,L) to checking whether X is a member of L.

member(X,[X|_]).
member(X,[Y|L]):- member(X,L).
