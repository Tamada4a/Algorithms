# 1757. Recyclable and Low Fat Products
Table: `Products`  
<pre>
+-------------+---------+  
| Column Name | Type    |  
+-------------+---------+  
| product_id  | int     |  
| low_fats    | enum    |  
| recyclable  | enum    |  
+-------------+---------+  
product_id is the primary key (column with unique values) for this table.  
low_fats is an ENUM (category) of type ('Y', 'N') where 'Y' means this product is low fat and 'N' means it is not.  
recyclable is an ENUM (category) of types ('Y', 'N') where 'Y' means this product is recyclable and 'N' means it is not.
</pre>

Write a solution to find the ids of products that are both low fat and recyclable.  

Return the result table in <b>any order</b>.  

The result format is in the following example.

## Example 1:
<pre>
<b>Input:</b> 
Products table:
+-------------+----------+------------+
| product_id  | low_fats | recyclable |
+-------------+----------+------------+
| 0           | Y        | N          |
| 1           | Y        | Y          |
| 2           | N        | Y          |
| 3           | Y        | Y          |
| 4           | N        | N          |
+-------------+----------+------------+
<b>Output:</b> 
+-------------+
| product_id  |
+-------------+
| 1           |
| 3           |
+-------------+
<b>Explanation:</b> Only products 1 and 3 are both low fat and recyclable.
</pre>