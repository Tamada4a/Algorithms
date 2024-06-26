# H. Забег по стадиону
<table>
  <tr>
      <td>Ограничение времени</td>
      <td>1 секунда</td>
  </tr>
  <tr>
      <td>Ограничение памяти</td>
      <td>256Mb</td>
  </tr>
  <tr>
      <td>Ввод</td>
      <td>стандартный ввод или input.txt</td>
  </tr>
  <tr>
      <td>Вывод</td>
      <td>стандартный вывод или output.txt</td>
  </tr>
</table>

Стадион представляет собой окружность <b>длиной <i>L</i></b> метров, на которой отмечена точка старта. По стадиону бегают Кирилл и Антон. 
У каждого мальчика есть своя точка старта (она представляет собой расстояние в метрах от старта, отсчитанное по часовой стрелке) 
и своя скорость в метрах в секунду (положительная скорость означает, что мальчик бежит по часовой стрелке, отрицательная — что 
бежит против часовой, а нулевая — что он стоит на месте). Вам нужно сказать, через какое минимальное время мальчики окажутся на 
одинаковом расстоянии от точки старта. Обратите внимание, что в этот момент они могли находиться в разных точках. Расстоянием 
от точки <i>A</i> до точки <i>B</i> называется минимальное из расстояний, которое нужно пробежать из точки <i>A</i> по или против часовой стрелки, 
чтобы оказаться в <i>B</i>.

## Формат ввода
В единственной строке вводится 5 целых чисел <i>L</i>, <i>x<sub>1</sub></i>, <i>v<sub>1</sub></i>, <i>x<sub>2</sub></i>, <i>v<sub>2</sub></i> (1 ≤ <i>L</i> ≤ 10<sup>9</sup>, 0 ≤ <i>x<sub>1</sub></i>, <i>x<sub>2</sub></i> < <i>L</i>, <i>v<sub>1</sub></i>, <i>v<sub>2</sub></i> ≤ 10<sup>9</sup>) 
— длины стадиона в метрах, начальная точка Кирилла, скорость Кирилла, начальная точка Антона, скорость Антона.

## Формат вывода
В первой строке выведите слово «YES», если случится момент, когда мальчики будут на одинаковом расстоянии от старта, или «NO», если такого момента не произойдёт.  

Если ответ «YES», то во второй строке выведите одно вещественное число — через какое минимальное количество времени мальчики окажутся на одинаковом расстоянии от старта.  

Вы можете выводить каждую букву в любом регистре (строчную или заглавную). Например, строки «yEs», «yes», «Yes» и «YES» будут приняты как положительный ответ.  

Ваш ответ будет считаться правильным, если его абсолютная или относительная ошибка не превосходит 10<sup>-9</sup>.  

Формально, пусть ваш ответ равен <i>a</i>, а ответ жюри равен <i>b</i>. Ваш ответ будет зачтен, если и только если $\Large\frac{|a−b|}{max(1, |b|)}$ ≤ 10<sup>-9</sup>.  

## Пример 1
| Ввод      | Вывод                |
|:----------|:---------------------|
| 6 3 1 1 1 | YES</br>1.0000000000 |

## Пример 2
| Ввод         | Вывод                |
|:-------------|:---------------------|
| 12 8 10 5 20 | YES</br>0.3000000000 |

## Пример 3
| Ввод      | Вывод                |
|:----------|:---------------------|
| 5 0 0 1 2 | YES</br>2.0000000000 |

## Пример 4
| Ввод        | Вывод                |
|:------------|:---------------------|
| 10 7 -3 1 4 | YES</br>0.8571428571 |

## Примечания
В первом тесте Кирилл изначально находится в точке 3 и бежит по часовой стрелке со скоростью 1. Антон находится в точке 1 и 
также бежит по часовой стрелке со скоростью 1. Через 1 секунду мальчики окажутся в точках 4 и 2 соответственно. Обе эти точки 
расположены на расстоянии 2 метра от старта (точки 0, совпадающей с точкой 6). Можно показать, что до этого они всегда 
находились на разном расстоянии от старта. Значит, ответ — 1.  

Во втором тесте оба мальчика окажутся в точке 11 через 0.3 
секунды.  

В третьем Антон прибежит к Кириллу в точку 0 за 2 секунды.
