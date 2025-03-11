CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    dept_location VARCHAR(50)
);


CREATE TABLE employee (
    Eid INT PRIMARY KEY,
    Ename VARCHAR(50),
    Esal FLOAT,
    dept_id INT NOT NULL,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

INSERT INTO department (dept_id, dept_name, dept_location) VALUES 
(10, "HR", "Mumbai"),
(11, "Fin", "Delhi"),
(12, "MI", "Noida");


INSERT INTO employee (Eid, Ename, Esal, dept_id) VALUES 
(1, "John", 3000.00, 11),
(2, "Doe", 4000.00, 11),
(3, "Lore", 5000.00, 12),
(4, "Ipsum", 4500.00, 12),
(5, "Odor", 3500.00, 12);


#retrive employees with the minimum salary in each department
SELECT * FROM employee WHERE Esal IN (SELECT MIN(Esal) FROM employee GROUP BY dept_id);


#retrive employee where salary of =, min, max salary in each dept using any
SELECT * FROM employee WHERE Esal =any (SELECT MIN(Esal) FROM employee GROUP BY dept_id);

SELECT * FROM employee WHERE Esal >any (SELECT MIN(Esal) FROM employee GROUP BY dept_id);

SELECT * FROM employee WHERE Esal <any (SELECT MIN(Esal) FROM employee GROUP BY dept_id);


#retrive employee whose sal is greater than all of min salary of each dept
select * from employee where Esal > all (select min(Esal) from employee group by dept_id);
select * from employee;
select min(Esal) from employee group by dept_id;

select Ename,Esal,dept_id FROM employee d WHERE Esal> (SELECT avg(Esal) from employee e WHERE d.dept_id =e.dept_id );

create view emp_view as select Esal from employee;
select * from emp_view;
# drop view emp_view;
create or replace  view emp_view as select Ename,Esal from employee;
select * from emp_view;


#create user
create user 'sam1'@'localhost' IDENTIFIED BY '789';
Alter user  'sam1'@'localhost' IDENTIFIED BY '678';
Drop user 'sam1'@'localhost';

select user  from mysql.user;

create role 'manager_role';
drop role 'manager_role';




