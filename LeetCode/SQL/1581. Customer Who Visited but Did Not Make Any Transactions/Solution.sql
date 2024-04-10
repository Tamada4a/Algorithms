SELECT A.customer_id, COUNT(A.customer_id) AS count_no_trans FROM 
(SELECT V.customer_id, T.transaction_id FROM Visits as V LEFT JOIN Transactions AS T USING(visit_id)) AS A 
WHERE A.transaction_id IS NULL GROUP BY A.customer_id; 