# 1 task
<table>
  <tr>
      <td>Time limit</td>
      <td>1 second</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>256 MB</td>
  </tr>
</table>

Kostya is connected to the mobile operator «Mobile». Kostya's subscription fee is <i>A</i> rubles per month. For this cost, 
Kostya receives <i>B</i> megabytes of Internet traffic. If Kostya goes beyond the traffic limit, then every next megabyte will 
cost him <i>C</i> rubles.  

Kostya plans to spend <i>D</i> megabytes of Internet traffic next month. Help him calculate how many rubles the Internet will cost him.

## Input data format
4 positive integers are entered <i>A</i>, <i>B</i>, <i>C</i>, <i>D</i> (1 ≤ <i>A</i>, <i>B</i>, <i>C</i>, <i>D</i> ≤ 100) — the cost of 
the Kostya's tariff, the size of the Kostya's tariff, the cost of each extra megabyte, the size of the Kostya's Internet traffic in the 
next month. The numbers in the input file are separated by spaces.

## Output data format
Print one natural number — the total cost of the Kostya on the Internet.

## Remark
In the first example, Kostya will first pay for an Internet package, after which he will spend 5 megabytes more than allowed by the tariff. 
Therefore, for 5 megabytes it supplements separately, the resulting cost is 100 + 12 × 5 = 160 rubles.

In the second example, Kostya fits into the tariff plan, so he pays only for it.

## Examples of data

### Example 1
| Input        | Output |
|:-------------|:-------|
| 100 10 12 15 | 160    |

### Example 2
| Input        | Output |
|:-------------|:-------|
| 100 10 12 1  | 100    |