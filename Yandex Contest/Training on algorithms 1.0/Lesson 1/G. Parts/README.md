# G. Parts

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

There is *N* kg of metal alloy. It is used to make workpieces weighing * K* kg each. After that, parts weighing *M* kg each are turned out of each 
workpiece (the maximum possible number of parts is turned out of each workpiece). If something remains of the workpieces after that, then this material 
is returned to the beginning of the production cycle and fused with what remains during the manufacture of workpieces. If the alloy that turned out is 
enough to make at least one workpiece, then workpieces are made from it again, parts are made from them, etc. Write a program that calculates how many parts 
can be obtained using this technology from the initially available *N* kg alloy.

## Input format
*N*, *K*, *M* are entered. All numbers are natural and do not exceed 200.

## Output format
Print one number — the number of parts that can be produced using this technology.

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
        10 5 2
      </td>
      <td>
        4
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
        13 5 3
      </td>
      <td>
        3
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
        14 5 3
      </td>
      <td>
        4
      </td>
    </tr>
  </tbody>
</table>