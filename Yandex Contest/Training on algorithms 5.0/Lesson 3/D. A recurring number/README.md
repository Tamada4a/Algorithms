# D. A recurring number
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

You are given a sequence of measurements of some magnitude. It is required to determine whether any number was repeated, and the distance between 
repetitions did not exceed <i>k</i>.

## Input format
The first line contains two numbers <i>n</i> and <i>k</i> (1 ≤ <i>n</i>, <i>k</i> ≤ 10<sup>5</sup>).   

The second line contains <i>n</i> numbers modulo no more than 10<sup>9</sup>.

## Output format
Print YES if there is a repeating number and the distance between repetitions does not exceed <i>k</i> and NO otherwise.

## Example 1
| Input           | Output |
|:----------------|:-------|
| 4 2</br>1 2 3 1 | NO     |

## Example 2
| Input           | Output |
|:----------------|:-------|
| 4 1</br>1 0 1 1 | YES    |

## Example 3
| Input               | Output |
|:--------------------|:-------|
| 6 2</br>1 2 3 1 2 3 | NO     |
