# for p2
```
	lex p2.l
	gcc lex.yy.c
	echo "hello" | ./a.out
```

# for p3
```
	lex p2.l
	gcc lex.yy.c
	echo "hello" | ./a.out
```

# p4
```
	lex p2.l
	gcc lex.yy.c
	./a.out < main.c

```
# p5
```
	lex p2.l
	gcc lex.yy.c
	./a.out main.c
```

# p7
press ctrl+d/ctrl+z to signal end of input

# p9
```
	yacc -d valid.y
	lex valid.l
	gcc -o valid y.tab.c
```