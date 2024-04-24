# 1. Сумма двух элементов
Вводится массив целых чисел `nums` и целое число `target`, верните <i>индексы двух чисел, которые в сумме дают `target`</i>.   

Вы можете быть уверены, что существует <b><i>ровно</i> одно решение</b>. Также вы не можете использовать <i>один и тот же</i> элемент дважды.  

Индексы в ответе могут располагаться в любом порядке.  

## Пример 1:
<pre>
<b>Ввод:</b> nums = [2,7,11,15], target = 9
<b>Вывод:</b> [0,1]
<b>Объяснение:</b> Поскольку nums[0] + nums[1] == 9, мы возвращаем [0, 1].
</pre>

## Пример 2:
<pre>
<b>Ввод:</b> nums = [3,2,4], target = 6
<b>Вывод:</b> [1,2]
</pre>

## Пример 3:
<pre>
<b>Ввод:</b> nums = [3,3], target = 6
<b>Вывод:</b> [0,1]
</pre>

## Ограничения:
- <code>2 <= nums.length <= 10<sup>4</sup></code>
- <code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code>
- <code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code>
- <b>Существует только один правильный ответ.</b>

## Вызов: 
Можете ли вы придумать алгоритм, временная сложность которого была бы меньше <code>O(n<sup>2</sup>)</code>?