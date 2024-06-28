# C. Deleting numbers
<table>
  <tr>
      <td>Time limit</td>
      <td>1 second</td>
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

Given an array <i>a</i> of <i>n</i> numbers. Find the minimum number of numbers after deleting which the pairwise difference of the remaining 
numbers modulo will not exceed 1, that is, after deleting, no number should differ from any other by more than 1.

## Input format
The first line contains a single integer <i>n</i> (1 ≤ <i>n</i> ≤ 2·10<sup>5</sup>) — the number of elements of the array <i>a</i>.  

The second line contains <i>n</i> integers <i>a<sub>1</sub></i>, <i>a<sub>2</sub></i>, …, <i>a<sub>n</sub></i> (0 ≤ <i>a<sub>i</sub></i>≤ 10<sup>5</sup>) — elements of the array <i>a</i>.

## Output format
Print one number — the answer to the problem.

## Example 1
| Input           | Output |
|:----------------|:-------|
| 5</br>1 2 3 4 5 | 3      |

## Example 2
| Input                      | Output |
|:---------------------------|:-------|
| 10</br>1 1 2 3 5 5 2 2 1 5 | 4      |
