# G. Build a square

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

A set consisting of <i>N</i> different points on the plane is given. The coordinates of all points are integers. Determine the minimum number of points to add to the set so that there are four points 
lying at the vertices of the square.

## Input format
In the first line, enter the number <i>N</i> (1 ≤ <i>N</i> ≤ 2000) — the number of points.  

In the following <i>N</i> lines, two numbers are entered <i>x<sub>i</sub></i>, <i>y<sub>i</sub></i> (-10<sup>8</sup> ≤ <i>x<sub>i</sub></i>, <i>y<sub>i</sub></i> ≤ 10<sup>8</sup>) — coordinates of 
points.

## Output format
In the first line, print the number <i>K</i> — the minimum number of points to be added to the set.  

In the following <i>K</i> lines, print the coordinates of the added points<i>x<sub>i</sub></i>, <i>y<sub>i</sub></i> separated by a space. The coordinates must be integers and not exceed 
10<sup>9</sup> modulo.  

If there are several solutions, print any of them.

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
        2</br>
        0 1</br>
        1 0
      </td>
      <td>
        2</br>
        0 0</br>
        1 1
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
        3</br>
        0 2</br>
        2 0</br>
        2 2
      </td>
      <td>
        1</br>
        0 0
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
        4</br>
        -1 1</br>
        1 1</br>
        -1 -1</br>
        1 -1
      </td>
      <td>
        0
      </td>
    </tr>
  </tbody>
</table>
