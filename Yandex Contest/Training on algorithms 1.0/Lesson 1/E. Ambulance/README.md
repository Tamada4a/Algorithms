# E. Ambulance

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
      <td>standart input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standart output or output.txt</td>
  </tr>
</table>

An ambulance crew went on call to one of the remote areas. Unfortunately, when the dispatcher received the call, he managed to write down only the address of the house and the apartment 
number *K<sub>1</sub>*, and then the connection was interrupted. However, he remembered that at the same address of the house some time ago, an ambulance went to the apartment *K<sub>2</sub>*, 
which is located in the entrance *P<sub>2</sub>* on the floor *N<sub>2</sub>*. It is known that the house has *M* floors and the number of apartments on each landing is the same. Write a 
program that calculates the entrance number *P<sub>1</sub>* and the floor number *P<sub>1</sub>* of the apartment *K<sub>1</sub>*.

## Input format
The input file contains five positive integers *K<sub>1</sub>*, *M*, *K<sub>2</sub>*, *P<sub>2</sub>*, *N<sub>2</sub>*. All numbers do not exceed 10<sup>6</sup>.

## Output format
Print two numbers *P<sub>1</sub>* and *N<sub>1</sub>*. If the input data does not allow you to uniquely identify *P<sub>1</sub>* or *N<sub>1</sub>*, type 0 instead of the corresponding number. 
If the input data is inconsistent, print two -1 numbers (minus one).

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
        89 20 41 1 11
      </td>
      <td>
        2 3
	</br>
      </td>
    </tr>
  </tbody>
</table>

## Example 2
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
        11 1 1 1 1
      </td>
      <td>
        0 1
	</br>
      </td>
    </tr>
  </tbody>
</table>

## Example 3
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
        3 2 2 2 1
      </td>
      <td>
        -1 -1
	</br>
      </td>
    </tr>
  </tbody>
</table>
