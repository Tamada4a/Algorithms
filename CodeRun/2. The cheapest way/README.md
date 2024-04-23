# 2. The cheapest way
In each cell of the rectangular table <i>N</i> × <i>M</i> a certain number is written. Initially, the player is in the upper left cell. 
In one move, he is allowed to move to the next cell either to the right or down (it is forbidden to move left and up). When passing through 
a cell, the player is charged as many kilograms of food as the number written in this cell (food is also taken for the first and last cells 
of his path).  

It is required to find the minimum weight of food in kilograms, giving which the player can get into the lower right corner.

## Input format
Two numbers are entered <i>N</i> and <i>M</i> — the dimensions of the table (1 ≤ <i>N</i> ≤ 20, 1 ≤ <i>M</i> ≤ 20). Then there are <i>N</i> 
lines of <i>M</i> numbers in each — the size of the fines in kilograms for passing through the corresponding cells (numbers from 0 to 100).

## Output format
Print the minimum weight of the food in kilograms, giving which you can get to the lower right corner.

## Example 1
<table>
  <thead>
    <tr>
      <th align= "left">Input</th>
      <th align= "left">Output</th>
    </tr>
  </thead>
  <tbody>
    <tr>
        <td>
		5 5</br>
		1 1 1 1 1</br>
		3 100 100 100 100</br>
		1 1 1 1 1</br>
		2 2 2 2 1</br>
		1 1 1 1 1
        </td>
        <td>11</td>
    </tr>
  </tbody>
</table>