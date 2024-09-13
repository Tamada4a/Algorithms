# B. One-dimensional naval battle

<table>
  <tr>
      <td>Time limit</td>
      <td>2 seconds</td>
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

The field in the game of one-dimensional naval combat has dimensions of 1 × <i>n</i>. Your task is to find such a maximum <i>k</i> that one ship of size 
1 × <i>k</i>, two ships of size 1 × (<i>k</i>-1), ..., <i>k</i> ships of the size of 1 × 1, and the ships, as in a normal naval battle, should not touch 
each other and intersect.

## Input format
In a single line of input data, the number <i>n</i> is given — the number of cells of the field (0 ≤ <i>n</i> ≤ 10<sup>18</sup>).

## Output format
Print a single number — such a maximum <i>k</i> that you can arrange the ships as described in the condition.

## Example
| Input | Output |
|:------|:-------|
| 7     | 2      |

## Notes
Explanation for example: for a 1 × 7 field, the answer is 2. You can arrange one ship of size 1 × 2 and two ships of size 1 × 1 as follows: 
<div align="center"><img src="./assets/sea-battle.png?raw=true" alt="Ships location" height="88"/></div>