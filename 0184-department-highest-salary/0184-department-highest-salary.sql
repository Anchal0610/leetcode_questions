# Write your MySQL query statement bhttps://leetcode.com/$0e
SELECT d.name as Department , e.name as Employee , e.salary as Salary 
FROM Employee e
JOIN Department d
ON e.departmentId = d.id
WHERE e.salary >= ALL(SELECT salary 
FROM Employee 
WHERE departmentId = e.departmentId);
