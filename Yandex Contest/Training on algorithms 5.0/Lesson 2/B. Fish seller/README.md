# B. Fish seller
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

Vasya decided to engage in the fish trade. Using machine learning methods, he predicted fish prices for <i>N</i> days ahead. He decided that 
one day he would buy a fish, and one of the next days he would sell it (that is, he would either make exactly one purchase and sale or not 
make any purchases and sales at all if it did not bring him profit). Unfortunately, fish is a perishable commodity and the difference between 
the number of the day of sale and the number of the day of purchase should not exceed <i>K</i>.  

Determine what maximum profit Vasya will receive.

## Input format
The first line of the input data contains the numbers <i>N</i> and <i>K</i> (1 ≤ <i>N</i> ≤ 10000, 1 ≤ <i>K</i> ≤ 100).  

The second line sets the prices for fish in each of the <i>N</i> days. The price is an integer that can range from 1 to 10<sup>9</sup>.

## Output format
Print one number — the maximum profit that Vasya will receive.

## Example 1
| Input                  | Output  |
|:-----------------------|:--------|
| 5 2</br>1 2 3 4 5</br> | 2       |

## Example 2
| Input                  | Output  |
|:-----------------------|:--------|
| 5 2</br>5 4 3 2 1</br> | 0       |
