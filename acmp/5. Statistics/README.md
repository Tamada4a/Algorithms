# 5. Statistics
<i>(Time: 1 sec. Memory: 16 Mb. Difficulty: 15%)</i> 
 
Vasya does not like English, but every time he tries to get at least a four in a quarter in order to remain a drummer. In the current 
quarter, Vasya noticed the following pattern: on odd days of the month he received threes, and on even days he received fours. He also 
remembers on which days he received these grades. Therefore, he wrote out all these days on a piece of paper in order to estimate how 
many threes and how many fours he had. Help Vasya to do this by arranging the even and odd numbers in different lines. Vasya can count 
on a score of 4 if there are no fewer fours than threes.
 
## Input data
In the first line of the input file INPUT.TXT the only number N is written – the number of elements of an integer array (1 ≤ N ≤ 100). 
The second line contains N numbers representing the specified array. Each element of the array is a natural number from 1 to 31. All 
elements of the array are separated by a space.

## Output data
To the first line of the output file OUTPUT.TXT you need to print the numbers that correspond to the days of the months in which Vasya 
received threes, and in the second line, respectively, place the numbers of the month in which Vasya received fours. In the third line, 
you need to print «YES» if Vasya can count on a four and «NO» otherwise. In each line, the numbers should be output in the same order as 
they appear in the input data. When output, the numbers are separated by a space.


## Examples
<table>
  <thead>
    <tr>
      <th align= "center">№</th>
      <th align= "center">INPUT.TXT</th>
      <th align= "center">OUTPUT.TXT</th>
    </tr>
  </thead>
  <tbody>
    <tr>
		<td>
			1
		</td>
		<td>
			5</br>
			4 16 19 31 2
		</td>
		<td>
			19 31</br>
			4 16 2</br>
        YES
		</td>
    </tr>
    <tr>
		<td>
    		2
		</td>
		<td>
			8</br>
			29 4 7 12 15 17 24 1
		</td>
		<td>
			29 7 15 17 1</br>
			4 12 24</br>
			NO
		 </td>
    </tr>
  </tbody>
</table>