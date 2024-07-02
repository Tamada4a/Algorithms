# 3 task
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

Katya has a busy day at work. She needs to transfer *n* different contracts to her colleagues. All meetings take place on different floors, and 
you can only move between floors by flights of stairs — it is believed that this improves the physical fitness of employees. The passage of each 
flight takes exactly 1 minute.  

Katya is currently on the parking floor, planning her route. Colleagues can be visited in any order, but one of them will leave the office in *t* 
minutes. There are no stairs from the parking floor — only an elevator that can take you to any floor.  

As a result, Katya's plan is as follows:
- Take the elevator to an arbitrary floor. It is considered that the elevator rises to any floor in 0 minutes.
- Transfer contracts to all colleagues by moving between floors up the stairs. It is believed that contracts on the floor are transferred instantly.
- In the first *t* minutes, transfer the contract to the colleague who plans to leave.
- Go through the minimum number of flights of stairs.

Help Katya complete all the points of her plan.

## Input data format
The first line contains positive integers *n* and *t* (2 ≤ *n*, *t* ≤ 100) — the number of employees and the time when one of the employees will 
leave the office (in minutes). In the next line of *n* numbers are the numbers of the floors where the employees are located. All numbers are 
different and do not exceed 100 in absolute value. The floor numbers are given in ascending order. The next line contains the number of the 
employee who will leave in *t* minutes.

## Output data format
Print one number — the minimum possible number of flights of stairs that Katya will need to go through.

## Remark
In the first example, there is enough time for Katya to go up the floors in order.  

In the second example, Katya will need to go up to the outgoing employee, and then go through all the others — for example, in the order 
{1,2,3,4,6}.

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
		5 5</br>
		1 4 9 16 25</br>
		2
      </td>
      <td>
        24
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
		6 4</br>
		1 2 3 6 8 25</br>
		5
      </td>
      <td>
        31
	  </td>
    </tr>
  </tbody>
</table>