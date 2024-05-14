% Write a Program in PROLOG to implement sublist(S, L) that checks whether the list S is the
% sublist of list L or not. (Check for sequence or the part in the same order).

sublist([],[]).
sublist([First|Rest],[First|Sub]):- sublist(Rest,Sub).
sublist([_|Rest],Sub):-sublist(Rest,Sub).
