# Write your MySQL query statement below
Select e.name as Employee
FROM Employee e
JOIN Employee m 
on e.managerId = m.id
Where e.salary > m.salary;
