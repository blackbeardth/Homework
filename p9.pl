% program to implement conc(L1,L2,L3) where L2 is the kust to be
% appended with L1 to get the resulted list L3.

conc([],L,L).
conc([X|L1],L2,[X|L3]):-conc(L1,L2,L3).
