# B. Before the exam
time limit per test: 0.5 second
memory limit per test: 64 megabytes
input: standard input
output: standard output

Petya has a biology exam tomorrow. He really dislikes this subject, but <i>d</i> found out a few days ago that he still had to take it. 
Strict parents immediately punished Petya to engage in preparation, and at the same time no less than <i>minTime<sub>i</sub></i> and no 
more than <i>maxTime<sub>i</sub></i> hours in <i>i</iThe 1st day. In addition, they warned Petya that the day before the exam they would 
check how he followed their instructions.  

And it is precisely today that parents demand from Petya the schedule of his classes. However, the boy counted only the total number of hours 
<i>sumTime</i> spent on preparation. Now he wants to find out if he can provide his parents with a list of <i>schedule</i> of <i>d</i> integers, 
in which each number <i>schedule<sub>i</sub></i> means the time in hours spent by Petya in <i>i</i> is the 1st day of studying biology. The 
numbers must meet the constraints of the parents, and the sum of all <i>schedule<sub>i</sub></i> must be exactly equal to <i>sumTime</i>.

## Input data
The first line of the input data contains two integers <i>d</i>, <i>sumTime</i> (1 ≤ <i>d</i> ≤ 30, 0 ≤ <i>sumTime</i> ≤ 240) — the number of 
days during which Petya was also engaged in the total number of hours spent on preparation. The following <i>d</i> lines contain two integers 
each <i>minTime<sub>i</sub></i>, <i>maxTime<sub>i</sub></i> (0 ≤ <i>minTime<sub>i</sub></i> ≤ <i>maxTime<sub>i</sub></i>≤ 8), separated by a 
space — the minimum and maximum number of hours that Petya could spend on the <i>i</i>th day.

## Output data
Print <i>YES</i> in the first line, and in the second <i>d</i> integers separated by spaces, each of which is the number of hours spent by Petya 
on preparation on the corresponding day. If it is impossible to create the desired list, then output <i>NO</i> in a single line of output data. 
If there are several solutions, print any one.

## Examples
<table>
  <thead>
    <tr>
      <th align= "left">Input data</th>
      <th align= "left">Output data</th>
    </tr>
  </thead>
  <tbody>
    <tr>
        <td>
			1 48</br>
			5 7
        </td>
        <td>NO</td>
    </tr>
  </tbody>
</table>

<table>
  <thead>
    <tr>
      <th align= "left">Input data</th>
      <th align= "left">Output data</th>
    </tr>
  </thead>
  <tbody>
    <tr>
        <td>
			2 5</br>
			0 1</br>
			3 5
        </td>
        <td>
			YES</br>
			1 4 
		</td>
    </tr>
  </tbody>
</table>