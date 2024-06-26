# 1581. Посетители, не совершившие ни одной покупки
Таблица: `Visits`  
<pre>
+------------------+---------+
| Название столбца | Тип     |
+------------------+---------+
| visit_id         | int     |
| customer_id      | int     |
+------------------+---------+
visit_id - это столбец с уникальными значениями для этой таблицы.
В этой таблице содержится информация о клиентах, посетивших торговый центр.
</pre>

Таблица: `Transactions`  
<pre>
+------------------+---------+
| Название столбца | Тип     |
+------------------+---------+
| transaction_id   | int     |
| visit_id         | int     |
| amount           | int     |
+------------------+---------+
transaction_id - это столбец с уникальными значениями для данной таблицы.
Эта таблица содержит информацию о покупках, совершенных во время visit_id.
</pre>

Напишите решение, позволяющее найти идентификаторы посетителей торгового центра, не купивших ничего, и количество раз, когда они совершали такие посещения.

Выведите результат SQL-запроса в <b>любом порядке</b>.  

Формат результатов приведен в следующем примере.

## Пример 1:
<pre>
<b>Ввод:</b> 
Visits
+----------+-------------+
| visit_id | customer_id |
+----------+-------------+
| 1        | 23          |
| 2        | 9           |
| 4        | 30          |
| 5        | 54          |
| 6        | 96          |
| 7        | 54          |
| 8        | 54          |
+----------+-------------+
Transactions
+----------------+----------+--------+
| transaction_id | visit_id | amount |
+----------------+----------+--------+
| 2              | 5        | 310    |
| 3              | 5        | 300    |
| 9              | 5        | 200    |
| 12             | 1        | 910    |
| 13             | 2        | 970    |
+----------------+----------+--------+
<b>Вывод:</b> 
+-------------+----------------+
| customer_id | count_no_trans |
+-------------+----------------+
| 54          | 2              |
| 30          | 1              |
| 96          | 1              |
+-------------+----------------+
<b>Пояснение:</b>
Посетитель с id = 23 был в торговом центре один раз и совершил одну покупку во время посещения с id = 12.
Посетитель с id = 9 был в торговом центре один раз и совершил одну покупку во время посещения с id = 13.
Посетитель с id = 30 был в торговом центре один раз и не совершил никаких покупок.
Посетитель с id = 54 был в торговом центре три раза. В течение 2 посещений он не совершил никаких покупок, а в течение одного посещения он совершил 3 покупки.
Посетитель с id = 96 был в торговом центре один раз и не совершил никаких покупок.
Как мы видим, посетители с идентификаторами 30 и 96 был в торговом центре один раз, не совершив никаких покупок. Кроме того, посетитель 54 дважды был в торговом центре и не совершил никаких покупок.
</pre>