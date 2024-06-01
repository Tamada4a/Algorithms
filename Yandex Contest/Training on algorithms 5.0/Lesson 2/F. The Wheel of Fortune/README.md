# F. The Wheel of Fortune
<table>
  <tr>
      <td>Time limit</td>
      <td>1 second</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>64Mb</td>
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

The entertainment TV channel broadcasts the show «Wheel of Fortune». During the game, the participants of the show spin a large wheel 
divided into sectors. There is a number written in each sector of this wheel. After the wheel stops, a special arrow points to one of 
the sectors. The number in this sector determines the player's winnings.

The young participant of the show noticed that the wheel slows down during rotation due to the fact that the arrow touches the protrusions 
on the wheel located between the sectors. If the wheel rotates at an angular velocity of <i>v</i> degrees per second, and the arrow, moving 
from the sector <i>X</i> to the next sector, touches another protrusion, then the current angular velocity of the wheel decreases by 
<i>k</i> degrees per second. At the same time, if <i></i> ≤ <i>k</i>, then the wheel cannot overcome the obstacle and stops. In this case, 
the arrow will point to the sector <i>X</i>.

<div align="center"><img src="./assets/spinner.png?raw=true" alt="Spinner example" height="260"/></div>

The young participant of the show is going to spin the wheel. Knowing the order of the sectors on the wheel, he wants to make the wheel 
rotate at such an initial speed that after the wheel stops, the arrow points to as many numbers as possible. The wheel can be rotated in 
any direction and give it an initial angular velocity from <i>a</i> to <i>b</i> degrees per second.

It is required to write a program that calculates the maximum gain based on a given arrangement of numbers in sectors, the minimum and maximum 
initial angular velocity of the wheel and the amount of deceleration of the wheel when crossing the sector boundary.

## Input format
The first line of the input file contains an integer <i>n</i> — the number of sectors of the wheel (3 ≤ <i>n</i> ≤ 100).  

The second line of the input file contains <i>n</i> positive integers, each of which does not exceed 1000 — the numbers written in the 
sectors of the wheel. The numbers are given in the clockwise order of the sectors. Initially, the arrow points to the first number.  

The third line contains three integers: <i>a</i>, <i>b</i> and <i>k</i> (1 ≤ <i>a</i> ≤ <i>b</i> ≤ 10<sup>9</sup>, 1 ≤ <i>k</i> ≤ 10<sup>9</sup>). 

## Output format
The output file must contain a single integer — the maximum win.

## Example 1
| Input                     | Output |
|:--------------------------|:-------|
| 5</br>1 2 3 4 5</br>3 5 2 | 5      |

## Example 2
| Input                       | Output |
|:----------------------------|:-------|
| 5</br>1 2 3 4 5</br>15 15 2 | 4      |

## Example 3
| Input                     | Output |
|:--------------------------|:-------|
| 5</br>5 4 3 2 1</br>2 5 2 | 5      |

## Notes
In the first example, the following options are possible: you can set the initial speed of the wheel to 3 or 4, which will cause the 
arrow to overcome one boundary between sectors, or set the initial speed to 5, which will allow the arrow to overcome 2 boundaries 
between sectors. In the first case, if you spin the wheel in one direction, then the gain will be equal to 2, and if you spin it 
in the opposite direction, then — 5. In the second option, if you spin the wheel in one direction, then the win will be 3, and if 
in the other direction, then 4.  

In the second example, only one initial rotation speed of the wheel is possible — 15 degrees per second. In this case, when the wheel 
rotates, the arrow will overcome seven boundaries between sectors. Then if you spin it in one direction, then the gain will be 4, and 
if in the opposite direction, then 3.  

Finally, in the third example, the optimal initial rotation speed of the wheel is 2 degrees per second. In this case, the arrow will not 
be able to cross the border between the sectors at all, and the win will be 5.
