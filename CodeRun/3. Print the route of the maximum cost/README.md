# 3. Print the route of the maximum cost
There is a turtle in the upper left corner of a rectangular table with the size *N*×*M*. There is a number written in each cell of the table. 
The turtle can move to the right or down, with the turtle's route ending in the lower right corner of the table.  

Let's calculate the sum of the numbers written in the cells through which the turtle crawled (including the starting and ending cells). 
Find the largest possible value of this amount and the route on which this amount is reached.

## Input format
The first line of the input data contains two natural numbers *N* and *M*, not exceeding 100 — the size of the table. Next comes *N* rows, each of 
which contains *M* numbers separated by spaces — a description of the table. All the numbers in the cells of the table are integers and can take 
values from 0 to 100.

## Output format
The first line of the output contains the maximum possible amount, the second is the route on which this amount is reached. The route is 
displayed as a sequence, which must contain *N-1* letter *D*, which means moving down and *M-1* letter *R*, which means moving to the right. 
If there are several such sequences, it is necessary to output exactly one (any) of them.

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
		9 9 9 9 9</br>
		3 0 0 0 0</br>
		9 9 9 9 9</br>
		6 6 6 6 8</br>
		9 9 9 9 9
        </td>
        <td>
		74</br>
		D D R R R R D D
	</td>
    </tr>
  </tbody>
</table>
