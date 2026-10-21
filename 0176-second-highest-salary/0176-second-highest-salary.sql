WITH Ranked AS (
    SELECT salary,
           DENSE_RANK() OVER (ORDER BY salary DESC) AS ranking
    FROM Employee
)
SELECT MAX(salary) AS SecondHighestSalary
FROM Ranked
WHERE ranking = 2;