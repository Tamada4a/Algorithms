# I. Пираты Баренцева моря
<table>
  <tr>
      <td>Ограничение времени</td>
      <td>1 секунда</td>
  </tr>
  <tr>
      <td>Ограничение памяти</td>
      <td>64Mb</td>
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

Вася играет в настольную игру «Пираты Баренцева моря», которая посвящена морским битвам. Игровое поле представляет собой 
квадрат из <i>N</i> × <i>N</i> клеток, на котором расположено <i>N</i> кораблей (каждый корабль занимает одну клетку).  

Вася решил воспользоваться линейной тактикой, для этого ему необходимо выстроить все <i>N</i> кораблей в одном столбце. За 
один ход можно передвинуть один корабль в одну из четырёх соседних по стороне клеток. Номер столбца, в котором будут 
выстроены корабли, не важен. Определите минимальное количество ходов, необходимых для построения кораблей в одном столбце. 
В начале и процессе игры никакие два корабля не могут находиться в одной клетке.

## Формат ввода
В первой строке входных данных задаётся число <i>N</i> (1 ≤ <i>N</i> ≤ 100).  

В каждой из следующих <i>N</i> строк задаются координаты корабля: сначала номер строки, затем номер столбца (нумерация начинается с единицы).

## Формат вывода
Выведите одно число — минимальное количество ходов, необходимое для построения.

## Пример 
| Ввод                      | Вывод |
|:--------------------------|:------|
| 3</br>1 2</br>3 3</br>1 1 | 3     |

## Примечания
В примере необходимо выстроить корабли в столбце номер 2. Для этого необходимо переставить корабль из клетки 3 3 в клетку 3 2
за один ход, а корабль из клетки 1 1 в клетку 2 2 за два хода. Существуют и другие варианты перестановки кораблей, однако ни 
в одном из них нет меньше трёх ходов.
