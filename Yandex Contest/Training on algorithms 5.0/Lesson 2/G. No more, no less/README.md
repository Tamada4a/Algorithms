# G. No more, no less
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

An array of positive integers <i>a</i> of length <i>n</i> is given. Divide it into the minimum possible number of segments so that each 
number is at least the length of the segment to which it belongs. The length of a segment is the number of numbers in it.  

Splitting an array into segments is considered correct if each element belongs to exactly one segment.

## Input format
The first line contains a single integer <i>t</i> (1 ≤ <i>t</i> ≤ 1000) — the number of test data sets. This is followed by <i>t</i> sets 
of test data.  

The first line of the test data set contains a single integer <i>n</i> (1 ≤ <i>n</i> ≤ 10<sup>5</sup>) — the length of the array.  

The next line contains <i>n</i> integers <i>a<sub>1</sub></i>, <i>a<sub>2</sub></i>, …, <i>a<sub>n</sub></i> 
(1 ≤ <i>a<sub>i</sub></i> ≤ <i>n</i>) — array <i>a</i>.  

It is guaranteed that the sum <i>n</i> for all test data sets does not exceed 2·10<sup>5</sup>.

## Output format
For each set of test data, print the number <i>k</i> in the first line — the number of segments in your partition.  

Then in the next line print <i>k</i> numbers <i>len<sub>1</sub></i>, <i>len<sub>2</sub></i>, …, <i>len<sub>k</sub></i> 
(1 ≤ <i>len<sub>i</sub></i> ≤ <i>n</i>, $\Large\sum_{i=1} len_i$ = <i>n</i>) — lengths of segments in order from left to right.

## Example
| Input                                                                                    | Output                                      |
|:-----------------------------------------------------------------------------------------|:--------------------------------------------|
| 3</br>5</br>1 3 3 3 2</br>16</br>1 9 8 7 6 7 8 9 9 9 9 9 9 9 9 9</br>7</br>7 2 3 4 3 2 7 | 3</br>1 2 2</br>3</br>1 6 9</br>3</br>2 3 2 |

## Notes
The answers in the example correspond to the partitions:
<i>{[1], [3, 3], [3, 2]}</i>  
<i>{[1], [9, 8, 7, 6, 7, 8], [9, 9, 9, 9, 9, 9, 9, 9, 9]}</i>  
<i>{[7, 2], [3, 4, 3], [2, 7]}</i>  

In the first set of test data, the set of lengths <i>{1, 3, 1}</i> corresponding to the partition <i> {[1], [3, 3, 3], [2]}</i>, 
would also be correct.
