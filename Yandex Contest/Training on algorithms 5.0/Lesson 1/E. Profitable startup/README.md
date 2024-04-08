# E. Profitable startup
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

<i>k</i> friends have organized a startup for the production of ukuleles for cats. To date, the profit has amounted to <i>n</i> rubles. 
As the chief accountant of the company, you want to add one digit to the end of the profit number in each of the next <i>d</i> days
. At the same time, on each of the days, the profit should be divided by <i>k</i>.

## Input format
Three numbers are written in a single line of input data separated by a space: <i>n</i>, <i>k</i>, <i>d</i> — the initial profit,
the number of founders of the company and the number of days that you are going to monitor the profit (1 ≤ <i>n</i>, k ≤ 10<sup>9</sup>,
1 ≤ d ≤ 10<sup>5</sup>). <b>IT is NOT</b>guaranteed that <i>n</i> is divisible by <i>k</i>.

## Output format
Print a single integer <i>x</i> — the company's profit in <i>d</i> days. The first digits of the number <i>x</i> must match the number
<i>n</i>. All prefixes of the number <i>x</i> that are longer than the number <i>n</i> by 1, 2, ..., <i>d</i> digits must be divisible 
by <i>k</i>. If there are several possible answers, print any of them. If there is no answer, print -1.

## Example 1
| Input    | Output |
|:---------|:-------|
| 21 108 1 | 216    |

## Example 2
| Input  | Output |
|:-------|:-------|
| 5 12 4 | -1     |

## Notes
In the first test example, you only need to monitor the profit for one day. You can add the number 6 to the end of the number 21 and get
a profit divided by 108.  

In the second test example, on the very first day we cannot make a profit divisible by <i>k</i>, no matter which digit is
appended to the number <i>n</i>, therefore there is no answer.
