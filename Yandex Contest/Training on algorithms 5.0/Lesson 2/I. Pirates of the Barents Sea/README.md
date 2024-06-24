# I. Pirates of the Barents Sea
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

Vasya is playing the board game «Pirates of the Barents Sea», which is dedicated to naval battles. The playing field is a square of 
<i>N</i> × <i>N</i> cells, on which there are <i>N</i> ships (each ship occupies one cell).  

Vasya decided to use linear tactics, for this he needs to line up all <i>N</i> ships in one column. In one move, you can move one ship to 
one of the four adjacent cells on the side. The number of the column in which the ships will be lined up is not important. Determine the 
minimum number of moves required to line up ships in one column. At the beginning and during the game, no two ships can be in the same cell.

## Input format
The first line of the input data contains the number <i>N</i> (1 ≤ <i>N</i> ≤ 100).  

In each of the following <i>N</i> lines, the coordinates of the ship are set: first the row number, then the column number 
(numbering starts with one).

## Output format
Print one number — the minimum number of moves required to line up.

## Example 
| Input                     | Output |
|:--------------------------|:-------|
| 3</br>1 2</br>3 3</br>1 1 | 3      |

## Notes
In the example, you need to line up the ships in column number 2. To do this, you need to move the ship from cell 3 3 to cell 3 2 in one move, 
and the ship from cell 1 1 to cell 2 2 in two moves. There are other options for rearranging ships, but none of them has less than three moves.
