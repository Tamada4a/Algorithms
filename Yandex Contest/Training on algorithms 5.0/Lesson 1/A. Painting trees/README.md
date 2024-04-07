# A. Painting trees
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
      <td>standard input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standard output or output.txt</td>
  </tr>
</table>

Vasya and Masha participate in the clean-up and paint the tree trunks white. Trees grow along the street at regular intervals
of 1 meter. One of the trees is marked with the number zero, the trees on one side are numbered with positive numbers 1, 2, etc.,
and on the other with negative numbers -1, -2, etc.  

A bucket of paint for Vasya was installed near the tree <i>P</i>, and for Masha — near the tree <i>Q</i>. Buckets of paint are very heavy and Vasya
and Masha cannot rearrange them, so they dip the brush into the bucket and go to paint the tree with this brush. Paint on a brush from a bucket of Vasya 
it dries up when it moves away from the bucket by more than <i>V</i> meters, and from Masha's bucket by <i>M</i> meters. Determine how many trees can be painted.

## Input format
The first line contains two integers <i>P</i> and <i>V</i> — the number of the tree that has Vasya's bucket and how many trees it can move away from it.  

The second line contains two integers <i>Q</i> and <i>M</i> — similar data for Masha.  

All numbers are integers and modulo no more than 10<sup>8</sup>.

## Output format
Print one number — the number of trees that can be painted.

## Example
| Input        | Output |
|:-------------|:-------|
| 0 7</br>12 5 | 25     |
