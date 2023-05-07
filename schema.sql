USE COMPANY;

CREATE TABLE EMPLOYEE
(
    Eno           CHAR(3)     NOT NULL,
    Ename         VARCHAR(50) NOT NULL,
    Job_type      VARCHAR(50) NOT NULL,
    SupervisorENo CHAR(3),
    Hire_date     DATE        NOT NULL,
    Dno           INT,
    Commission    DEC(10, 2),
    Salary        DEC(7, 2)   NOT NULL,
    PRIMARY KEY (Eno)
);

CREATE TABLE DEPARTMENT
(
    Dno      INT NOT NULL,
    Dname    VARCHAR(50),
    Location VARCHAR(50) DEFAULT 'New Delhi',
    PRIMARY KEY (Dno)
);

ALTER TABLE EMPLOYEE
    ADD CONSTRAINT SupervisorConstraint
        FOREIGN KEY (SupervisorENo) REFERENCES EMPLOYEE (Eno);

ALTER TABLE EMPLOYEE
    ADD CONSTRAINT DepartmentConstraint
        FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno);

INSERT INTO DEPARTMENT
VALUES (10, 'Headquarters', 'Mumbai'),
       (45, 'Legal', 'Mumbai'),
       (30, 'IT', 'Bengaluru'),
       (20, 'Outreach', 'Dallas'),
       (95, 'Purchase', 'Dallas');

INSERT INTO DEPARTMENT (Dno, Dname)
VALUES (90, 'Sales'),
       (40, 'Administration'),
       (50, 'Research');

INSERT INTO EMPLOYEE
VALUES ('778', 'John Smith', 'Managing Director', NULL, '1980-06-12', 10, NULL, 5800.23),
       ('153', 'Andy Beaford', 'Manager', '778', '2000-09-08', 40, NULL, 502.30),
       ('23', 'Chirag Wadhwa', 'Manager', '778', '1981-11-21', 30, NULL, 2465.92),
       ('25', 'Anmol Gupta', 'Manager', '778', '1981-09-11', 40, NULL, 2865.92),
       ('86', 'Tania Chauhan', 'Manager', '778', '1983-08-14', 90, 235.90, 2921.37),
       ('89', 'Alicia Jones', 'Manager', '778', '1982-10-26', 95, NULL, 980.35),
       ('232', 'Isa Jaques', 'Manager', '778', '1996-07-23', 45, NULL, 651.05),
       ('520', 'King Hethron', 'Manager', '778', '2015-10-13', 90, NULL, 497.18),
       ('188', 'Sherline Harbord', 'Manager', '778', '1995-08-05', 40, NULL, 926.42),
       ('146', 'Donielle Tuite', 'Intern', '520', '2016-06-12', 90, NULL, 171.60),
       ('125', 'Gurpreet Singh', 'Intern', NULL, '2008-05-15', NULL, NULL, 521.37),
       ('243', 'Marie Brahms', 'Engineer', '23', '1983-06-22', 40, NULL, 876.78),
       ('299', 'Mahala Burtwhistle', 'Analyst', '89', '1990-07-20', 95, NULL, 602.86),
       ('354', 'Bryna McKenny', 'Analyst', '153', '2001-10-11', 90, NULL, 693.63),
       ('421', 'Ulberto Gosz', 'Assistant', NULL, '2017-02-07', 10, NULL, 381.64),
       ('442', 'Netti Dellenbrok', 'Designer', '23', '2014-05-14', 30, NULL, 790.82),
       ('492', 'Salmon Gough', 'Assistant', '86', '2008-12-13', 90, 148.80, 998.32),
       ('504', 'Berny Bonas', 'Accountant', '778', '2008-05-24', 40, NULL, 779.34),
       ('516', 'Lowell Paule', 'Systems Administrator', '23', '2008-03-31', 30, 324.39, 969.66),
       ('518', 'Nicholas Comelini', 'Accountant', '188', '1997-03-20', 90, 546.04, 882.53);