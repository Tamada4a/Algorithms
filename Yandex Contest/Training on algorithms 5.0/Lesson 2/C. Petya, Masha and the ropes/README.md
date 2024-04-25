# C. Петя, Маша и верёвочки
<table>
  <tr>
      <td>Time limit</td>
      <td>1 second</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>512Mb</td>
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

There were two identical strings of a positive length on the table.  

Petya cut one of the ropes into <i>N</i> parts, each of which has a positive integer length, so that there were <i>N + 1</i> 
ropes on the table. Then Masha came into the room and took one of the strings lying on the table. By the lengths of the 
remaining <i>N</i> ropes on the table, determine which <b>the smallest</b> length the rope taken by Masha can have.

## Input format
The first line of the input data contains a single integer <i>N</i> — the number of ropes remaining on the table 
(2 ≤ <i>N</i> ≤ 1000). The second line contains <i>N</i> integers <i>l<sub>i</sub></i> — lengths of ropes 
(1 ≤ <i>l<sub>i</sub></i>≤ 1000).

## Output format
Print a single integer — the smallest length that the string taken by Masha can have.

## Example 1
| Input              | Output  |
|:-------------------|:--------|
| 4</br>1 5 2 1</br> | 1       |

## Example 2
| Input               | Output  |
|:--------------------|:--------|
| 4</br>5 12 4 3</br> | 24      |