# B. Одномерный морской бой

<table>
  <tr>
      <td>Ограничение времени</td>
      <td>2 секунды</td>
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

Поле в игре в одномерный морской бой имеет размеры 1 × <i>n</i>. Ваша задача — найти такое максимальное <i>k</i>, что на поле 
можно расставить один корабль размера 1 × <i>k</i>, два корабля размера 1 × (<i>k</i>−1), ..., <i>k</i> кораблей размера 1 × 1, 
причем корабли, как и в обычном морском бое, не должны касаться друг друга и пересекаться.

## Формат ввода
В единственной строке входных данных дано число <i>n</i> — количество клеток поля (0 ≤ <i>n</i> ≤ 10<sup>18</sup>).

## Формат вывода
Выведите единственное число — такое максимальное <i>k</i>, что можно расставить корабли, как описано в условии.

## Пример
| Ввод | Вывод |
|:-----|:------|
| 7    | 2     |

## Примечания
Пояснение к примеру: для поля 1 × 7 ответ равен 2. Расставить один корабль размера 1 × 2 и два корабля размера 1 × 1 можно 
следующим образом:
<div align="center"><img src="./assets/sea-battle.png?raw=true" alt="Ships location" height="88"/></div>