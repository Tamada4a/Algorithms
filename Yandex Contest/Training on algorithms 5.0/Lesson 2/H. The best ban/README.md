# H. The best ban
<table>
  <tr>
      <td>Time limit</td>
      <td>3 seconds</td>
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

Konstantin and Mikhail are playing the board game "Fury of the Elves". The game has <i>n</i> races and <i>m</i> character 
classes. Each character is characterized by their own race and class. For each race and each class, there is exactly one 
character of such a race and such a class. The strength of a character of the <i>i</i>-th race and <i>j</i>-th class is equal 
to <i>a<sub>ij</sub></i>, and both players are well aware of this.  

Now Konstantin will choose his character. Before that, Mikhail can ban one race <b>and</b> one class, so that Konstantin 
cannot choose characters who have such a race <b>or</b> such a class. Of course, Mikhail tries to ensure that Konstantin 
gets the weakest character possible, while Konstantin, on the contrary, chooses a stronger character. Which race and class should 
Mikhail ban?

## Input format
The first line contains two integers <i>n</i> and <i>m</i> (2 ≤ <i>n</i>, <i>m</i> ≤ 1000) separated by a space — the number 
of races and classes in the game «Fury of the Elves», accordingly.  

The following <i>n</i> lines contain <i>m</i> integers separated by a space. <i>j</i>-th number <i>i</i>-th of these lines is 
<i>a<sub>ij</sub></i> (1 ≤ <i>a<sub>ij</sub></i> ≤ 10<sup>9</sup>).

## Output format
In a single line, print two integers separated by a space — the race number and the class number, which should be forbidden to Mikhail. 
Races and classes are numbered from one. If there are several possible answers, print any of them.

## Example 1
| Input               | Output |
|:--------------------|:-------|
| 2 2</br>1 2</br>3 4 | 2 2    |

## Example 2
| Input                                      | Output |
|:-------------------------------------------|:-------|
| 3 4</br>1 3 5 7</br>9 11 2 4</br>6 8 10 12 | 3 2    |
