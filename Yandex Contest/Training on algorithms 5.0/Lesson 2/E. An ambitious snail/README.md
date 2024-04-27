# E. An ambitious snail
<table>
  <tr>
      <td>Time limit</td>
      <td>5 seconds</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>256Mb</td>
  </tr>
  <tr>
      <td>Input</td>
      <td>standart input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standart output or output.txt</td>
  </tr>
</table>

The pet of the boy Vasya is Petya the snail. Petya lives on an infinite vertical column in both directions, which for 
convenience can be represented as a numerical line. Initially, Petya is at point 0.  

Vasya feeds Petya berries. He has <i>n</i> berries, each in a single copy. Vasya knows that if in the morning he gives Petya 
a berry with the number <i>i</i>, then after eating and gaining strength, Petya will climb <i>a<sub>i</sub></i> units up the 
column for the rest of the day, but at the same time overnight, heavier, it will move down by <i>b<sub>i</sub></i> units. 
The parameters of different berries may match.  

Petya wondered how it was up there, and Vasya undertook to help him with this. For the next <i>n</i> days, he will feed Petya 
berries from his stock in such a way that the maximum height that Petya has visited during these <i>n</i> days is maximum. 
Unfortunately, Vasya does not know how to program, so he asked you for help. Find the maximum height that Petya will be able 
to visit during these <i>n</i> days and in what order Vasya should give Petya berries so that Petya can get it!

## Input format
The first line of the input data contains the number <i>n</i> (1 ≤ <i>n</i> ≤ 5·10<sup>5</sup>) — the number of berries Vasya has. 
The following <i>n</i> lines describe the parameters of each berry. The <i>i + 1</i>-th string contains two numbers 
<i>a<sub>i</sub></i> and <i>b<sub>i</sub></i> (0 ≤ <i>a<sub>i</sub></i>, <i>b<sub>i</sub></i>≤ 10<sup>9</sup>) — how much the snail 
will rise in the day after eating the <i>i</i>-th berry and how much it will fall overnight.

## Output format
In the first line of the output, print a single number — the maximum height that Petya can reach if Vasya feeds him optimally. In 
the next line, print <i>n</i> different integers from 1 to <i>n</i> — the order in which Vasya should feed Petya (<i>i</i>-th number 
in the line corresponds to the number of berries that Vasya should give Petya in the <i>i</i>-th day so that Petya could reach the 
maximum height).

## Example 1
| Input                          | Output       |
|:-------------------------------|:-------------|
| 3</br>1 5</br>8 2</br>4 4</br> | 10</br>2 3 1 |

## Example 2
| Input             | Output     |
|:------------------|:-----------|
| 2</br>7 6</br>7 4 | 10</br>2 1 |

## Notes
In the second example, the snail is initially at a height of 0. Let Petya feed it with the second berry first, and then with the 
first. After she eats the second berry, during the day she will rise by 7 (and will be at a height of 7), and during the night she 
will fall by 4 (and will be at a height of 3). After she eats the first berry, during the day she will rise by 7 (and will be at 
a height of 10), and during the night she will fall by 6 (and will be at a height of 4).  

Thus, the maximum height that a snail will visit in this feeding order is 10. It is easy to see that if Petya feeds the snail 
first with the first berry, and then with the second, then the maximum height at which the snail will visit will be less.
