# F. Misha and mathematics
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
      <td>standard input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standard output or output.txt</td>
  </tr>
</table>

Misha was sitting in mathematics classes at the Higher School of Economics and solving the following problem: given <i>n</i> integers 
and you need to place the signs + and × between them so that the result of the resulting arithmetic expression is 
odd (for example, between the numbers 5, 7, 2, you can place arithmetic signs as follows: 5 × 7 + 2 = 37). As the tasks became longer and longer, and Misha urgently runs away to visit, you are required to write a program that solves this problem.

## Input format
The first line contains the singular <i>n</i>(1 ≤ <i>n</i> ≤ 10<sup>5</sup>). The second line contains <i>n</i>
integers <i>a<sub>i</sub></i> separated by spaces (-10<sup>9</sup> ≤ <i>a<sub>i</sub></i> ≤ 10<sup>9</sup>). It is guaranteed that
the solution exists.

## Output format
In one line, print <i>n − 1</i> the + or × character, which results in an odd result. (For output
, use the characters "+" (ASCII code — 43) and "x" (ASCII code — 120), without quotes, respectively).

## Example 1
| Input       | Output |
|:------------|:-------|
| 3</br>5 7 2 | x+     |

## Пример 2
| Input      | Output |
|:-----------|:-------|
| 2</br>4 -5 | +      |
