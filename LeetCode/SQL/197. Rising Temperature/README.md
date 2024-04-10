# 197. Rising Temperature
Table: `Weather`  
<pre>
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id is the column with unique values for this table.
There are no different rows with the same recordDate.
This table contains information about the temperature on a certain day.
</pre>

Write a solution to find all dates' `Id` with higher temperatures compared to its previous dates (yesterday).

Return the result table in <b>any order</b>.

The result format is in the following example.

## Example 1:
<pre>
<b>Input:</b> 
Weather table:
+----+------------+-------------+
| id | recordDate | temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
<b>Output:</b> 
+----+
| id |
+----+
| 2  |
| 4  |
+----+
<b>Explanation:</b> 
In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
</pre>