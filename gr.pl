% Write a PROLOG program that will take grammar rules in the following format:
%
% NT -> (NT | T)*
%
% Where NT is any nonterminal, T is any terminal and Kleene star (*)
% signifies any number of repetitions, and generate the corresponding
% top-down parser, that is:
%
% sentence -> noun-phrase, verb-phrase
% determiner -> [the]
%
% will generate the following:
%
% sentence (I, O) :- noun-phrase(I,R), verb-phrase (R,O).
% determiner ([the|X], X) :- !.
% sentence(X,Y):-np(X,Z),vp(Z, Y).

np(X,Y):-det(X,Z),noun(Z,Y).
vp(X,Y):-verb(X,Z),np(Z,Y).
vp(X,Y):-verb(X,Y).
det([a|X],X).
det([an|X],X).
det([the|X],X).
noun([boy|X],X).
noun([girl|X],X).
noun([song|X],X).
noun([apple|X],X).
verb([sing|X],X).
verb([sings|X],X).
verb([eats|X],X).
