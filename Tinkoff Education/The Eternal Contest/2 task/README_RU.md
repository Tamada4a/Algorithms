# 2 задание
<table>
  <tr>
      <td>Ограничение времени</td>
      <td>1 секунда</td>
  </tr>
  <tr>
      <td>Ограничение памяти</td>
      <td>256 МБ</td>
  </tr>
</table>

Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать рулет на <i>﻿N﻿</i> равных частей. 
Разумеется, рулет можно резать только поперек. Соотвественно, Костя сделает ﻿<i>﻿N − 1</i>﻿ разрез ножом через равные промежутки.  

По возвращению с кофе-брейка Ваня задумался — а можно ли было обойтись меньшим числом движений, будь нож Вани бесконечно длинным 
(иначе говоря, если он мог бы сделать сколько угодно разрезов за раз, если эти разрезы лежат на одной прямой)? Считается, что места 
для разрезов намечены заранее, и все разрезы делаются с ювелирной точностью.  

Оказывается, что можно. Например, если Ваня хотел бы разделить рулет на ﻿4﻿ части, он мог бы обойтись двумя разрезами — сначала он 
разделил бы рулет на две половинки, а потом совместил бы две половинки и разрезал обе пополам одновременно.  

Вам дано число ﻿<i>﻿N﻿</i>﻿, требуется сказать, каким минимальным числом разрезов можно обойтись.

## Формат входных данных
Дано одно натуральное число ﻿<i>﻿N﻿</i>(1 ≤ <i>﻿N﻿</i> ≤ 2 × 10<sup>9</sup>)﻿ — количество людей на кофе-брйке.

## Формат выходных данных
Выведите одно число — минимальное число движений, которое придется сделать Косте.

## Замечение
Чтобы разрезать рулет на ﻿6﻿ частей, Ване сначала придется разрезать его на две равные части, после чего совместить две половинки и 
сделать два разреза.  

Чтобы разрезать рулет на 5﻿ частей, Ване понадобится разделить его в соотношении ﻿2:3﻿, после чего совместить два рулета по левому краю 
и разрезать бОльший рулет на одинарные кусочки — меньший тоже разделится на одинарные.

## Примеры данных

### Пример 1
| Ввод | Вывод |
|:-----|:------|
| 6    | 3     |

### Пример 2
| Ввод | Вывод |
|:-----|:------|
| 5    | 3     |