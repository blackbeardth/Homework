# SQL

SQL stands for structured query language. It is used to create, retrieve, update, delete data from a database.
Types of database:
1. relational - It contains tables(rows and coloumns); It uses SQL
2. non-relational - Any other format; It uses NoSQL

Different DBMS: MySQL, Microsoft SQL server, Oracle, PostgreSQL, etc.

---

## SQL Commands

### Database
```sql
CREATE DATABASE datbase_name; 

DROP DATABASE database_name; 

USE database_name; 

ALTER DATABASE database_name READ ONLY = 1; -- makes database read only

ALTER DATABASE current_database_name -- rename a database
MODIFY NAME = new_database_name;
```


### Table and columns

==add columns to table==

```sql
CREATE TABLE table_name (
	column_name column_type constraints(optional) DEFAULT value(optional),
	column_name column_type constraints(optional) DEFAULT value(optional),
	.
	.
	.
);
```


==renames table==

```sql
RENAME TABLE table_name new_table_name; 
```

==delete table==

```sql
DROP TABLE table_name;
```

==add columns to a table==

```sql
ALTER TABLE table_name 
ADD column_name type;
```

==delete column==

```sql
ALTER TABLE table_name
DROP COLUMN column_name;
```

==rename a column==

```sql
ALTER TABLE table_name 
RENAME COLUMN column_name TO new_column_name; 
```

==change type of a column==

```sql
ALTER TABLE table_name 
MODIFY COLUMN column_name type; 
```

==move column_1 after column_2==

```sql
ALTER TABLE table_name 
MODIFY column_name_1 type 
AFTER column_name_2; 
```

==moves column to first place==

```sql
ALTER TABLE table_name 
MODIFY column_name_1 type 
FIRST;
```



### INSERT

==insert data into table==

```sql
INSERT INTO table_name
VALUES (column_1_value, column_2_value, ...),
(column_1_value, column_2_value, ...),
.
.
(column_1_value, column_2_value, ...); 
```

==insert data into certain columns==

```sql
INSERT INTO table_name (column_1, column_2, column_3)
VALUES (column_1_value, column_2_value, column_3_value); 
```


### SELECT
```sql
--selects all columns
SELECT * FROM table_name; 

--selects listed columns
SELECT coloumn_1, column_2, ... 
FROM table_name; 

--selects all columns with WHERE clause
SELECT * FROM table_name
WHERE condition;
```

> NOTE: To search a column which contains NULL, use 'IS' instead of '='.


### UPDATE & DELETE

==UPDATE VALUES IN A ROW==

```sql
-- Use update when you have to add data to a single column

UPDATE table_name
SET column_1 = value_1, column_2 = value_2, ... ;
WHERE condition (optional);
```

==DELETE A ROW FROM TABLE==

```sql
DELET FROM table_name
WHERE condition(optional);
```


### Autocommit, Commit, Rollback
> NOTE: Autocommit is by default on;

```sql
SET AUTOCOMMIT = OFF; -- Turns of autocommit
COMMIT; -- Manual commit changes to database
ROLLBACK; -- Rollsback to previous commit
```


### CURRENT DATE & TIME
```sql
INSERT INTO table_name
VALUES (CURRENT_DATE(), CURRENT_TIME(), NOW()); --NOW() is used for current datetime
```

> Date format: yyyy-mm-dd
> Time format: hh:mm:ss(24 hours)
> Datetime format: date time
> CURRENT_DATE() + 1 = tommorow's date


### Constraints

#### UNIQUE 
==add UNIQUE constraint to an already created column==

```sql
ALTER TABLE table_name
ADD CONSTRAINT
UNIQUE (column_name, column_name, . . .);
```

#### NOT NULL
==add NOT NULL constraint to an already created column==

```sql
ALTER TABLE table_name
MODIFY column_name column_type NOT NULL;
```

#### CHECK

```sql
--add contraint while table creation
CREATE TABLE table_name (
	column_1 column_1_type,
	.
	.
	CONSTRAINT constraint_name(optional) CHECK (condition)
);

--add CHECK constraint to an already created table
ALTER TABLE products
ADD CONSTRAINT onstraint_name(optional)
CHECK (condition);

---drop check
ALTER TABLE table_anme
DROP CHECK check_name;
```

#### DEFAULT

==add DEFAULT value to a column in an already created table==

```sql
ALTER TABLE table_name
ALTER column_name SET DEFAULT default_value;
```

> NOTE: when inserting you have to explicitly mention for which columns you are adding data. eg:

```sql
INSERT INTO TABLE (column1, column2) -- columns which don't have DEFAULT specified
VALUES  (value1, value2, . . .),
		(value1, value2, . . .),
		.
		.
		(value1, value2, . . .);
```


### PRIMARY KEY

==adding primary key constraint to an already created table==

```sql
ALTER TABLE table_name
ADD CONSTRAINT
PRIMARY KEY(column name);
```


### Auto increment

```sql
--add auto icnrement at table creation
CREATE TABLE tablename (
	tablename domain constraint,  etc AUTO_INCREMENT;
) AUTO_INCREMENT = starting value(optional)

--add auto icnrement after table creation
ALTER TABLE table_name MODIFY column_name datatype AUTO_INCREMENT;

--add auto icnrement start value after table creation
ALTER TABLE table_name AUTO_INCREMENT = value;

```

> You need to  explicitly mention the column name (other than the column having auto increment)for which you are adding the values


### FORIGN KEY

```sql
--add foreign key at table creation
CREATE TABLE table_name (
	column_name domain,
	.
	.
	CONSTRAINT constraint_name(optional)  
	FOREIGN KEY (column_name)
	REFERENCES other_table_name(other_column_name);
);

--add foreign key after table creation
ALTER TABLE table_name 
ADD CONSTRAINT constraint_name(optional) 
FOREIGN KEY (column_name) REFERENCES other_table_name(other_column_name);

--drop forign key
ALTER TABLE table_name
DROP FOREIGN KEY name_of_foreign_key;

```


### JOINS
> joins clause is used to combine rows from two or more tables based on a related column between them such as a foreign key

#### INNER JOIN
> Join together any matching rows based on some link

```sql
SELECT column_1, column_2, ...
FROM
table_1 INNER JOIN table_2
ON  table_1.column_name = table_2.column_name;
```

#### LEFT JOIN
> Join together all rows of the left table and any matching rows baased on some link

#### RIGHT JOIN
> Join together all rows of the right table and any matching rows baased on some link

#### SELF JOIN
```sql
-- join another copy of a table to itself
-- used t compare rows of teh same table
-- helps to dispaly a hierarchy of data

SELECT  A.column_1, A.column_2, ... ,
        CONCAT(B.column_1, B.column_2, ...) AS "alias"
FROM table_name AS A
JOIN table_name AS B
ON A.column_name = B.column_name;

```


### Functions 

==COUNT()==

```sql
--Counts number of rows (not null) in a column
SELECT COUNT(column_name) AS "alias"(optional)
FROM table_name
WHERE condition(optional);
```

==MAX()==

```sql
--returns maximum value from rows in a column
SELECT MAX(column_name) AS "alias"(optional)
FROM table_name
WHERE condition(optional);
```

==MIN()==

```sql
--returns minimum value from rows in a column
SELECT MIN(column_name) AS "alias"(optional)
FROM table_name
WHERE condition(optional);
```

==AVG()==

```sql
--returns average of values from rows in a column
SELECT AVG(column_name) AS "alias"(optional)
FROM table_name
WHERE condition(optional);
```

==SUM()==

```sql
--returns sum of values from rows in a column
SELECT SUM(column_name) AS "alias"(optional)
FROM table_name
WHERE condition(optional);
```

==CONCAT()==

```sql
--returns a concatination of two or more columns
SELECT CONCAT(column_1, column_2, ...) AS "alias"(optional)
FROM table_name
WHERE condition(optional)
```


### Logical Operators

==AND
OR
NOT
BETWEEN
IN==


### Wildcard Characters

#### %

> Used to substitute any number of characters in a string.
> It is not case sensitive.

Ex:

```sql
--Select rows where column_name entry begins with 's'
SELECT * FROM table_name
WHERE column_name LIKE "S%";

--Select rows where column_name entry ends with 'sp'
SELECT * FROM employees
WHERE column_name LIKE "%sp";
```

#### _

> Used to represent one character in a string.
> It is not case sensitive.

Ex:

```sql
--Select rows where column_name entry starts with any letter followed by 'ook'
SELECT * FROM tabel-name
WHERE column_name "_ook";

--Select rows where column_name entry starts with any letter followed by 'oo' and ends with any letter
SELECT * FROM tabel-name
WHERE column_name "_oo_";

--Select rows where column_name entry has second letter as 'u'\
SLECET * FROM tabel-name
WHERE column_name "_u%";
```


### Order By

```sql
--Sorts the result of a query in either ascending or descending order
SELECT * FROM table_name
ORDER BY column_name ASC(optional);

--NOTE : By default the rows are ordred by ascending or alphabetical order

--To order by descending or reverse alphabetical order use 'DESC'
SELECT * FROM table_name  
ORDER BY column_name DESC;

--If two or more entries in the column have same value, then we can givce a seconds column to order the rows by
SELECT * FROM table_name  
ORDER BY column_name_1 ASC, column_name_2 DESC;
```


### LIMIT

> LIMIT clause is used to limit to number of records.
> Useful if you are working witha lot of data.
> Can be used to display a large data on pages (pagination). 

```sql
SELECT * FROM table_name
LIMIT no_of_rows;

--It can used alongside ORDER BY clause
SELECT * FROM table_name
ORDER BY column_name
LIMIT no_of_rows;

--You can add an offset, after which the number of records will be selected
SELECT * FROM table_name
LIMIT offset, no_of_rows;
 ```


### UNION
```sql
-- UNION combines the result of two or more SELECT statements

SELECT column1, column2 FROM table_1
UNION
SELECT column1, column2 FROM table_2;

```

> The combined tables must have same number of columns or specify same number of columns
> UNION does not allows duplicates
> UNION ALL does allows duplciates

### Views

```sql
-- a virtual table based on the result-set of an SQL statement
-- the felds in a view are fields from one or more real tables in the database
-- They are not real tables, but can be interacted with as they are one
-- all changes made in the view are reflected in the main table and vice versa

CREATE VIEW view_name AS
SELECT column_1, column_2, ...
FROM table_name;

```

### Indexes
> INDEX (BTree data structure)
> Indexes are used to find values within a specific column more quickly
> MYSQL normally searches sequentially through a column
> The longer the column, the mre expensive the operation is
> UPDATE takes more time, SELECT takes less time

```sql
-- Show indexes of a table
SHOW INDEXES FROM table_name;

-- Create an index
CREATE INDEX index_name
ON table_name(column_name);

-- Create a multi-column indexes
CREATE INDEX index_name
ON table_name(column_1, column_2,...); 

-- Note: The order of the columns is important

-- Drop an index
ALTER table table_name
DROP INDEX index_name;
```

### Subqueries

```sql
-- Ex1:
SELECT first_name, last_name, hourly_pay
FROM employees
WHERE hourly_pay > (SELECT AVG(hourly_pay) FROM employees);

-- Ex2:
SELECT  first_name, last_name, hourly_pay
		(SELECT AVG(hourly_pay) FROM employees) AS "avg_pay"
FROM employees;

-- Ex3:
SELECT first_name, last_name
FROM customers
WHERE customer_id IN 
(SELECT DISTINCT customer_id
FROM transactions
WHERE customer_id IS NOT NULL);

-- same thing without subqueries:
SELECT DISTINCT first_name, last_name 
FROM customers JOIN transactions
ON transactions.customer_id = customers.customer_id
ORDER BY transaction_id;
```

### GROUP BY