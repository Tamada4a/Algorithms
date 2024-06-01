# F. Колесо Фортуны
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

Развлекательный телеканал транслирует шоу «Колесо Фортуны». В процессе игры участники шоу крутят большое колесо, разделенное на 
сектора. В каждом секторе этого колеса записано число. После того как колесо останавливается, специальная стрелка указывает на 
один из секторов. Число в этом секторе определяет выигрыш игрока.  

Юный участник шоу заметил, что колесо в процессе вращения замедляется из-за того, что стрелка задевает за выступы на колесе, 
находящиеся между секторами. Если колесо вращается с угловой скоростью <i>v</i> градусов в секунду, и стрелка, переходя из 
сектора <i>X</i> к следующему сектору, задевает за очередной выступ, то текущая угловая скорость движения колеса уменьшается на 
<i>k</i> градусов в секунду. При этом если <i>v</i> ≤ <i>k</i>, то колесо не может преодолеть препятствие и останавливается. 
Стрелка в этом случае будет указывать на сектор <i>X</i>.

<div align="center"><img src="./assets/spinner.png?raw=true" alt="Spinner example" height="260"/></div>

Юный участник шоу собирается вращать колесо. Зная порядок секторов на колесе, он хочет заставить колесо вращаться с такой 
начальной скоростью, чтобы после остановки колеса стрелка указала на как можно большее число. Колесо можно вращать в любом 
направлении и придавать ему начальную угловую скорость от <i>a</i> до <i>b</i> градусов в секунду.  

Требуется написать программу, которая по заданному расположению чисел в секторах, минимальной и максимальной начальной 
угловой скорости вращения колеса и величине замедления колеса при переходе через границу секторов вычисляет максимальный 
выигрыш.

## Формат ввода
Первая строка входного файла содержит целое число <i>n</i> — количество секторов колеса (3 ≤ <i>n</i> ≤ 100).  

Вторая строка входного файла содержит <i>n</i> положительных целых чисел, каждое из которых не превышает 1000 — числа, 
записанные в секторах колеса. Числа приведены в порядке следования секторов по часовой стрелке. Изначально стрелка указывает 
на первое число.  

Третья строка содержит три целых числа: <i>a</i>, <i>b</i> и <i>k</i> (1 ≤ <i>a</i> ≤ <i>b</i> ≤ 10<sup>9</sup>, 
1 ≤ <i>k</i> ≤ 10<sup>9</sup>).  

## Формат вывода
В выходном файле должно содержаться одно целое число — максимальный выигрыш.

## Пример 1
| Ввод                      | Вывод |
|:--------------------------|:------|
| 5</br>1 2 3 4 5</br>3 5 2 | 5     |

## Пример 2
| Ввод                        | Вывод |
|:----------------------------|:------|
| 5</br>1 2 3 4 5</br>15 15 2 | 4     |

## Пример 3
| Ввод                      | Вывод |
|:--------------------------|:------|
| 5</br>5 4 3 2 1</br>2 5 2 | 5     |

## Примечания
В первом примере возможны следующие варианты: можно придать начальную скорость колесу равную 3 или 4, что приведет к тому, 
что стрелка преодолеет одну границу между секторами, или придать начальную скорость равную 5, что позволит стрелке преодолеть
2 границы между секторами. В первом варианте, если закрутить колесо в одну сторону, то выигрыш получится равным 2, а если 
закрутить его в противоположную сторону, то — 5. Во втором варианте, если закрутить колесо в одну сторону, то выигрыш будет 
равным 3, а если в другую сторону, то — 4.  

Во втором примере возможна только одна начальная скорость вращения колеса — 15 градусов в секунду. В этом случае при вращении 
колеса стрелка преодолеет семь границ между секторами. Тогда если его закрутить в одном направлении, то выигрыш составит 4, 
а если в противоположном направлении, то — 3.  

Наконец, в третьем примере оптимальная начальная скорость вращения колеса равна 2 градусам в секунду. В этом случае стрелка 
вообще не сможет преодолеть границу между секторами, и выигрыш будет равен 5.