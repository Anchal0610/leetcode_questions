# Write your MySQL query statement below
Select MAX(salary) as SecondHighestSalary from employee where salary < (Select MAX(salary) from employee) ;