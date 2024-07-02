# 4 task
<table>
  <tr>
      <td>Time limit</td>
      <td>2 seconds</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>256 MB</td>
  </tr>
</table>

Kostya has a piece of paper with *n* numbers written on it. He also has the opportunity to take any number from a piece of paper no more than 
*k* times, then paint over one of the old digits, and in its place write a new arbitrary digit.  

By what maximum value will Kostya be able to increase the sum of all the numbers on the piece of paper?

## Input data format
The first line of the input file contains two integers *n*, *k* — the number of numbers on the piece of paper and the limit on the number of 
operations.  

(1 ≤ *n* ≤ 1000, 1 ≤ *k* ≤ 10<sup>4</sup>)﻿.  

The second line contains *n* numbers *a<sub>i</sub>* — numbers on a piece of paper (1 ≤ *a<sub>i</sub>* ≤ 10<sup>9</sup>).

## Output data format
Output one number to the output file — the maximum difference between the final and initial sum.

## Remark
In the first example, Kostya can change two ones to two nines, as a result of which the sum of the numbers will increase by 16.  

In the second example, Kostya changes the number 85 to 95.  

In the third example, you can not change anything.  

Note that the response may exceed the capacity of the 32-bit data type.

## Examples of data

### Example 1
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
		5 2</br>
		1 2 1 3 5
      </td>
      <td>
        16
	  </td>
    </tr>
  </tbody>
</table>

### Example 2
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
		3 1</br>
		99 5 85
      </td>
      <td>
        10
	  </td>
    </tr>
  </tbody>
</table>

### Example 3
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
		1 10</br>
		9999
      </td>
      <td>
        0
	  </td>
    </tr>
  </tbody>
</table>
