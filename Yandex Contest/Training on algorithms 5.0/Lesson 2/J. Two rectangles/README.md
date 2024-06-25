# J. Two rectangles
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

Recently, a well-known abstract artist has produced a new masterpiece — the painting «Two black disjoint rectangles». The painting is a 
rectangle <i>m</i> × <i>n</i>, divided into 1 × 1 squares, some of which are painted over with the author's favorite color — black. Fedya is not 
a fan of abstract paintings, but he wondered if the painting really depicted two disjoint rectangles. Help him find out. The rectangles do not 
intersect in the sense that they do not have common cells.

## Input format
The first line of the input file contains the numbers <i>m</i> and <i>n</i> (1 ≤ <i>m</i>, <i>n</i> ≤ 200). The next m lines contain a description 
of the drawing. Each line contains exactly <i>n</i> characters. The «.» symbol indicates an empty square, and the «#» symbol indicates a shaded 
one.

## Output format
If the drawing can be represented as two disjoint rectangles, print «YES» in the first line, and in the following <i>m</i> lines, print the 
drawing in the same form as it is specified in the input file, replacing the squares corresponding to the first rectangle with the symbol «a», 
and the second with the «b» symbol. If there are several solutions, print any one.  

If this cannot be done, output «NO» to the output file.

## Example 1
| Input           | Output |
|:----------------|:-------|
| 2 1</br>#</br>. | NO     |

## Example 2
| Input             | Output            |
|:------------------|:------------------|
| 2 2</br>..</br>## | YES</br>..</br>ab |

## Example 3
| Input       | Output      |
|:------------|:------------|
| 1 3</br>### | YES</br>abb |

## Example 4
| Input         | Output        |
|:--------------|:--------------|
| 1 5</br>####. | YES</br>abbb. |
