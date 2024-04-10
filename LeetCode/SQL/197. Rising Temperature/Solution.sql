-- Selecting the id of day which one is hotter than yesterday
SELECT id FROM 
-- Selecting: the id corresponding to tomorrow; the temperature of today and tomorrow.
(SELECT W2.id AS id, W1.temperature AS T1, W2.temperature AS T2 
-- Where the current date is one day behind the next one
FROM Weather AS W1 JOIN Weather AS W2 ON W1.recordDate = (W2.recordDate - interval '1 day')) 
-- Where tomorrow temperature is higher then today
WHERE (T2 - T1) > 0;