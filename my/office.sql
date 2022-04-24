create database office;
use office;
create table employees(id int not null auto_increment primary key, first_name varchar(30) null, last_name varchar(30) null, salary int null, title enum('junior', 'middle', 'senior') not null default 'junior');
insert into employees (first_name, last_name, salary) values('my_name0', 'last0', 1215),('my_name1', 'last1', 380),('my_name2', 'last2', 904),('my_name3', 'last3', 551),('my_name4', 'last4', 442),('my_name5', 'last5', 2493),('my_name6', 'last6', 1350),('my_name7', 'last7', 2926),('my_name8', 'last8', 1756),('my_name9', 'last9', 2007),('my_name10', 'last10', 1673),('my_name11', 'last11', 2831),('my_name12', 'last12', 1288),('my_name13', 'last13', 1591),('my_name14', 'last14', 1890),('my_name15', 'last15', 2577),('my_name16', 'last16', 432),('my_name17', 'last17', 550),('my_name18', 'last18', 747),('my_name19', 'last19', 1797);
select * from employees;
update employees set title=2 where salary between 1000 and 1500;
select * from employees;
update employees set title = 3 where salary>1500;
select * from employees;
delete from employees where salary < 700