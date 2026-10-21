# Write your MySQL query statement below
WITH totalProductId AS(
    SELECT product_id , MIN(year) as first_year
    FROM Sales
    GROUP BY product_id
)
SELECT s.product_id , t.first_year , s.quantity , s.price
FROM Sales s
CROSS JOIN totalProductId t
WHERE s.product_id = t.product_id AND s.year = t.first_year;
