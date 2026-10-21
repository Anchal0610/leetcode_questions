# Write your MySQL query statement below
SELECT w.id as Id
FROM Weather w
JOIN Weather r
on DATEDIFF(w.recordDate , r.recordDate) = 1
WHERE w.temperature > r.temperature ;

