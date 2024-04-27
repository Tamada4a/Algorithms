# 2 task
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

Vanya brought a roll to the kitchen, which he wants to share with his colleagues. To do this, he wants to cut the roll into 
<i>N</i> equal parts. Of course, the roll can only be cut across. Accordingly, Kostya will make an <i>N − 1</i> incision with 
a knife at regular intervals.  

Upon returning from the coffee break, Vanya wondered if it would have been possible to do with fewer movements if Vanya's knife 
had been infinitely long (in other words, if he could have made as many cuts as he wanted at a time, if these cuts lay on the 
same straight line). It is believed that the places for the cuts are planned in advance, and all the cuts are made with jewelry 
precision.  

It turns out that it is possible. For example, if Vanya wanted to divide the roll into 4 parts, he could do with two cuts — first 
he would divide the roll into two halves, and then combine the two halves and cut both in half at the same time.  

You are given a number <i>N</i>, you need to say what is the minimum number of cuts you can do.

## Input data format
One natural number is given <i>N</i>(1 ≤ <i>N</i> ≤ 2 × 10<sup>9</sup>) — the number of people on the coffee bar.

## Output data format
Print one number — the minimum number of movements that Kostya will have to make.

## Remark
To cut the roll into 6 parts, Vanya will first have to cut it into two equal parts, then combine the two halves and make two cuts.  

To cut the roll into 5 parts, Vanya will need to divide it in a ratio of 2:3, then combine the two rolls on the left edge and cut 
the larger roll into single pieces — the smaller one will also be divided into single ones.

## Examples of data

### Example 1
| Input | Output |
|:------|:-------|
| 6     | 3      |

### Example 2
| Input | Output |
|:------|:-------|
| 5     | 3      |