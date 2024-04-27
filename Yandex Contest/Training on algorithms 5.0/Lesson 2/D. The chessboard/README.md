# D. The chessboard
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

A coherent (non-disintegrating) figure without holes was cut out of the chessboard along the borders of the cells. It is 
required to determine its perimeter.

## Input format
First, the number <i>N</i> (1 ≤ <i>N</i> ≤ 64) is entered – the number of cut cells. In the following <i>N</i> lines, 
the coordinates of the cut cells are entered, separated by a space (the row and column numbers are numbers from 1 to 8). 
Each cut cell is indicated once.

## Output format
Print one number – the perimeter of the sawn figure (the side of the cell is equal to one).

## Example 1
| Input                          | Output  |
|:-------------------------------|:--------|
| 3</br>1 1</br>1 2</br>2 1</br> | 8       |

## Example 2
| Input          | Output  |
|:---------------|:--------|
| 1</br>8 8</br> | 4       |

## Notes
1) A corner of three cells has been cut out. The sum of the lengths of its sides is 8.
2) One cell was cut out. Its perimeter is 4.
