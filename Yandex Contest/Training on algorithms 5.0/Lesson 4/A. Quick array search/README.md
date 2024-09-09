# A. Quick array search

<table>
  <tr>
      <td>Time limit</td>
      <td>3 seconds</td>
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

An array of <i>N</i> integers is given. All numbers from -10<sup>9</sup> to 10<sup>9</sup>.  

You need to be able to answer queries like “How many numbers have values from <i>L</i> to <i>R</i>?”.

## Input format
The number <i>N</i> (1 ≤ <i>N</i> ≤ 10<sup>5</sup>). Next <i>N</i> integers.  

Then the number of requests <i>K</i> (1 ≤ <i>K</i> ≤ 10<sup>5</sup>).  

Next <i>K</i> pairs of numbers <i>L</i>, <i>R</i> (-10<sup>9</sup> ≤ <i>L</i> ≤ <i>R</i> ≤ 10<sup>9</sup>) — the actual queries.

## Output format
Print <i>K</i> numbers — answers to queries.

## Example
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
        5</br>
        10 1 10 3 4</br>
        4</br>
        1 10</br>
        2 9</br>
        3 4</br>
        2 2
      </td>
      <td>
        5 2 2 0
      </td>
    </tr>
  </tbody>
</table>