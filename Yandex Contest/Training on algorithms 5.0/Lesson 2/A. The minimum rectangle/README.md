# A. The minimum rectangle
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

There are <i>K</i> cells painted over on the checkered plane. It is required to find a rectangle with a minimum area, with sides parallel to 
the grid lines, covering all the painted cells.

## Input format
In the input file, on the first line, there is a number <i>K</i> (1 ≤ <i>K</i> ≤ 100). The following <i>K</i> lines contain pairs of numbers 
<i>X<sub>i</sub></i> and <i>Y<sub>i</sub></i> — coordinates of the painted cells (|<i>X<sub>i</sub></i>|, |<i>Y<sub>i</sub></i>| ≤ 10<sup>9</sup>).

## Output format
Output the coordinates of the lower-left and upper-right corners of the rectangle to the output file.

## Example
| Input                                  | Output  |
|:---------------------------------------|:--------|
| 4</br>1 3</br>3 1</br>3 5</br>6 3</br> | 1 1 6 5 |
