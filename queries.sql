---
Questions

1. Query to display Employee Name, Job, Hire Date, Employee Number; for each employee
with the Employee Number appearing first.
2. Query to display unique Jobs from the Employee Table.
3. Query to display the Employee Name concatenated by a Job separated by a comma.
4. Query to display all the data from the Employee Table. Separate each Column by a comma
and name the said column as THE_OUTPUT.
5. Query to display the Employee Name and Salary of all the employees earning more than
$2850.
6. Query to display Employee Name and Department Number for the Employee No= 79.
7. Query to display Employee Name and Salary for all employees whose salary is not in the
range of $1500 and $2850.
8. Query to display Employee Name and Department No. of all the employees in Dept 10 and
Dept 30 in the alphabetical order by name.
9. Query to display Name and Hire Date of every Employee who was hired in 1981.
10. Query to display Name and Job of all employees who have not assigned a supervisor.
11. Query to display the Name, Salary and Commission for all the employees who earn
commission.
12. Sort the data in descending order of Salary and Commission.
13. Query to display Name of all the employees where the third letter of their name is ‘A’.
14. Query to display Name of all employees either have two ‘R’s or have two ‘A’s in their
name and are either in Dept No = 30 or their Manger’s Employee No = 7788.
15. Query to display Name, Salary and Commission for all employees whose Commission
amount is greater than their Salary increased by 5%.
16. Query to display the Current Date along with the day name.
17. Query to display Name, Hire Date and Salary Review Date which is the 1st Monday after
six months of employment.
18. Query to display Name and calculate the number of months between today and the date
on which employee was hired of department ‘Purchase’.
19. Query to display the following for each employee <E-Name> earns < Salary> monthly
but wants < 3 * Current Salary >. Label the Column as Dream Salary.
20. Query to display Name with the 1st letter capitalized and all other letter lower case and
length of their name of all the employees whose name starts with ‘J’, ’A’ and ‘M’.
21. Query to display Name, Hire Date and Day of the week on which the employee started.
22. Query to display Name, Department Name and Department No for all the employees.
23. Query to display Unique Listing of all Jobs that are in Department number 30.
24. Query to display Name, Dept Name of all employees who have an ‘A’ in their name.
25. Query to display Name, Job, Department No. And Department Name for all the
employees working at the Dallas location.
26. Query to display Name and Employee no. Along with their supervisor’s Name and the
supervisor’s employee no; along with the Employees’ Name who do not have a supervisor.
27. Query to display Name, Dept No. And Salary of any employee whose department No.
and salary matches both the department no. And the salary of any employee who earns a
commission.
28. Query to display Name and Salaries represented by asterisks, where each asterisk (*)
signifies $100.
29. Query to display the Highest, Lowest, Sum and Average Salaries of all the employees
30. Query to display the number of employees performing the same Job type functions.
31. Query to display the total number of supervisors without listing their names.
32. Query to display the Department Name, Location Name, No. of Employees and the
average salary for all employees in that department.
33. Query to display Name and Hire Date for all employees in the same dept. as Blake.
34. Query to display the Employee No. And Name for all employees who earn more than the
average salary.
35. Query to display Employee Number and Name for all employees who work in a
department with any employee whose name contains a ‘T’.
36. Query to display the names and salaries of all employees who report to supervisor named
‘King’
37. Query to display the department no, name and job for all employees in the Sales
department
38. Display names of employees along with their department name who have more than 20
years experience
39. Display total number of departments at each location
40. Find the department name in which at least 20 employees work in.
41. Query to find the employee’ name who is not supervisor and name of supervisor
supervising more than 5 employees.
42. Query to display the job type with maximum and minimum employees
---



USE COMPANY;

-- EMPLOYEE
DESC EMPLOYEE;

-- DEPARTMENT
DESC DEPARTMENT;

-- Q1
SELECT Eno,
       Ename,
       Job_type,
       Hire_date
FROM EMPLOYEE;

-- Q2
SELECT DISTINCT Job_type
FROM EMPLOYEE;

-- Q3
SELECT CONCAT(
               Ename, ',',
               Job_type
           ) AS Employee_Job
FROM EMPLOYEE;

-- Q4
SELECT CONCAT(
               Eno, ',',
               Ename, ',',
               Job_type, ',',
               IFNULL(SupervisorENo, ''), ',',
               Hire_date, ',',
               IFNULL(Dno, ''), ',',
               IFNULL(Commission, ''), ',',
               Salary
           ) AS THE_OUTPUT
FROM EMPLOYEE;

-- Q5
SELECT Ename,
       Salary
FROM EMPLOYEE
WHERE Salary > 2850;

-- Q6
SELECT Ename,
       Dno
FROM EMPLOYEE
WHERE Eno = '79';

-- Q7
SELECT Ename,
       Salary
FROM EMPLOYEE
WHERE Salary NOT BETWEEN 1500 AND 2850;

-- Q8
SELECT Ename,
       Dname
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
WHERE Dno IN (10, 30)
ORDER BY Ename;

-- Q9
SELECT Ename,
       Hire_date
FROM EMPLOYEE
WHERE Hire_date
          LIKE '1981______';

-- Q10
SELECT Ename,
       Job_type
FROM EMPLOYEE
WHERE SupervisorENo IS NULL;

-- Q11
SELECT Ename,
       Salary,
       Commission
FROM EMPLOYEE
WHERE Commission IS NOT NULL;

-- Q12
SELECT *
FROM EMPLOYEE
ORDER BY Salary DESC,
         Commission DESC;

-- Q13
SELECT Ename
FROM EMPLOYEE
WHERE Ename LIKE '__A%';

-- Q14
SELECT Ename
FROM EMPLOYEE
WHERE Ename LIKE '%R%R%'
   OR Ename LIKE '%A%A%'
   OR Dno = 30
   OR SupervisorENo = '778';

-- Q15
SELECT Ename,
       Salary,
       Commission
FROM EMPLOYEE
WHERE Commission > 1.05 * Salary;

-- Q16
SELECT DATE(NOW()),
       DAYNAME(NOW());

-- Q17
WITH RECORDS(Ename, Hire_date, Six_after) AS (
    SELECT Ename,
           Hire_date,
           DATE_ADD(Hire_date, INTERVAL 6 MONTH)
               AS Six_after
    FROM EMPLOYEE
)
SELECT RECORDS.Ename,
       RECORDS.Hire_date,
       DATE_ADD(
               RECORDS.Six_after,
               INTERVAL
               IF(
                       0 = WEEKDAY(RECORDS.Six_after),
                       0 - WEEKDAY(RECORDS.Six_after),
                       7 - WEEKDAY(RECORDS.Six_after) + 0
                   )
               DAY
           ) AS Salary_review_date
FROM RECORDS;

-- Q18
SELECT Ename,
       TIMESTAMPDIFF(MONTH, Hire_date, NOW())
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
WHERE Dname = 'Purchase';

-- Q19
SELECT CONCAT(
               Ename, ' earns $',
               Salary, ' monthly ',
               'but wants $', 3 * Salary
           )
           AS "Dream Salary"
FROM EMPLOYEE;

-- Q20
SELECT CONCAT(
               UPPER(SUBSTR(Ename, 1, 1)),
               LOWER(SUBSTR(Ename, 2))
           )
           AS "Name",
       LENGTH(Ename)
FROM EMPLOYEE
WHERE Ename LIKE 'J%'
   OR Ename LIKE 'A%'
   OR Ename LIKE 'M%';

-- Q21
SELECT Ename,
       Hire_date,
       DAYNAME(Hire_date)
FROM EMPLOYEE;

-- Q22
SELECT Ename,
       Dno,
       Dname
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT);

-- Q23
SELECT DISTINCT Job_type
FROM EMPLOYEE
WHERE Dno = 30;

-- Q24
SELECT Ename,
       Dname
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
WHERE Ename LIKE '%A%';

-- Q25
SELECT Ename,
       Job_type,
       Dno,
       Dname
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
WHERE Location = 'Dallas';

-- Q26
SELECT E.Ename,
       E.Eno,
       S.Ename AS SupervisorName,
       S.Eno   AS SupervisorEno
FROM EMPLOYEE AS E
         LEFT OUTER JOIN EMPLOYEE AS S
                         ON E.SupervisorENo = S.Eno;

-- Q27
SELECT L.Ename,
       L.Dno,
       L.Salary
FROM EMPLOYEE AS L,
     EMPLOYEE AS R
WHERE L.Dno = R.Dno
  AND L.Salary = R.Salary
  AND L.Eno <> R.Eno
  AND R.Commission IS NOT NULL;

-- Q28
SELECT Ename,
       RPAD('*', Salary / 100, '*') AS Salary_Star
FROM EMPLOYEE;

-- Q29
SELECT MAX(Salary),
       MIN(Salary),
       SUM(Salary),
       AVG(Salary)
FROM EMPLOYEE;

-- Q30
SELECT Job_type,
       COUNT(DISTINCT Eno)
FROM EMPLOYEE
GROUP BY Job_type;

-- Q31
SELECT COUNT(DISTINCT SupervisorENo)
FROM EMPLOYEE;

-- Q32
SELECT Dname,
       Location,
       COUNT(*)              AS NumberOfEmployees,
       ROUND(AVG(Salary), 2) AS AvgSalary
FROM EMPLOYEE
         NATURAL JOIN DEPARTMENT
GROUP BY EMPLOYEE.Dno;

-- Q33
SELECT Ename,
       Hire_date
FROM EMPLOYEE
WHERE Dno IN (
    SELECT Dno
    FROM EMPLOYEE
    WHERE Ename LIKE 'Blake%'
);

-- Q34
SELECT Ename,
       Salary
FROM EMPLOYEE
WHERE Salary > (
    SELECT AVG(Salary)
    FROM EMPLOYEE
);

-- Q35
SELECT Eno,
       Ename
FROM EMPLOYEE
WHERE Dno IN
      (
          SELECT Dno
          FROM EMPLOYEE
          WHERE Ename LIKE '%T%'
      );

-- Q36
SELECT Ename,
       Salary
FROM EMPLOYEE
WHERE SupervisorENo IN (
    SELECT Eno
    FROM EMPLOYEE
    WHERE Ename LIKE 'King%'
);

-- Q37
SELECT Dno,
       Ename,
       Job_type
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
WHERE Dname = 'Sales';

-- Q38
SELECT Ename,
       Dname
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
WHERE TIMESTAMPDIFF
          (
              YEAR,
              Hire_date,
              NOW()
          ) > 20;

-- Q39
SELECT Location,
       COUNT(*)
FROM DEPARTMENT
GROUP BY Location;

-- Q40
SELECT Dname
FROM (EMPLOYEE
         NATURAL JOIN DEPARTMENT)
GROUP BY Dno
HAVING COUNT(*) > 20;

-- Q41
(
    SELECT Ename
    FROM EMPLOYEE
    WHERE Eno NOT IN (
        SELECT DISTINCT SupervisorENo
        FROM EMPLOYEE
        WHERE SupervisorENo IS NOT NULL
    )
)
UNION
(
    SELECT Ename
    FROM EMPLOYEE
    WHERE Eno IN (
        SELECT SupervisorENo
        FROM EMPLOYEE
        WHERE SupervisorENo IS NOT NULL
        GROUP BY SupervisorENo
        HAVING COUNT(*) > 5
    )
);

-- Q42
WITH JOBCOUNT AS (
    SELECT COUNT(*) AS ECount
    FROM EMPLOYEE
    GROUP BY Job_type
)
SELECT Job_type,
       COUNT(*)
FROM EMPLOYEE
GROUP BY Job_type
HAVING COUNT(*) IN (
    (
        SELECT MAX(ECount)
        FROM JOBCOUNT
    )
    UNION
    (
        SELECT MIN(ECount)
        FROM JOBCOUNT
    )
);
