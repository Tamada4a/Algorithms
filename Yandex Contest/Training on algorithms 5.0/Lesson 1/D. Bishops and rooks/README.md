# D. Bishops and rooks
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
      <td>standard input or input.txt</td>
  </tr>
  <tr>
      <td>Outpup</td>
      <td>standard output or output.txt</td>
  </tr>
</table>

There are bishops and rooks on the chessboard, it is necessary to calculate how many cells none of the figures are beating.

The chessboard measures 8 by 8. The rook beats all the squares horizontally and vertically passing through the square where it stands,
up to the first figure encountered. The bishop beats all the cells of both diagonals passing through the cell where he stands to the first
figure that meets.

## Input format
The first eight lines of the input describe the chessboard. The first eight characters of each of these lines describe the state
of the corresponding horizontal: the symbol B (capital Latin letter) means that there is a bishop in the cell, the symbol R is a rook, the symbol * 
— that the cell is empty. After the description of the horizontal line, there may be spaces in the line, but the length of each line does not exceed 250 characters.
After the description of the board, there may be empty lines in the file.

## Output format
Print the number of empty cells that do not beat any of the figures.

## Example 1
| Input                                                                                                                                                                         | Output |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------|
| \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*R\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br>| 49     |

## Example 2
| Input                                                                                                                                                                         | Output |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------|
| \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*B\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br>| 54     |

## Example 3
| Input                                                                                                                                                                        | Output |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------|
| \*\*\*\*\*\*\*\*</br> \*R\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*B\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br> \*\*\*\*\*\*\*\*</br>| 40     |
