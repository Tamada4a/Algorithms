# C. Formatting the file
<table>
  <tr>
      <td>Time limit</td>
      <td>1 second</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>256Mb</td>
  </tr>
  <tr>
      <td>Input</td>
      <td>standard input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standard output or output.txt</td>
  </tr>
</table>

Petya is a novice programmer. Today he wrote a code of <i>n</i> lines.  

Unfortunately, it turned out that this code is difficult to read. Petya decided to fix this by adding spaces in various places. More precisely, for the <i>i</i>-th line he needs to add <b>exactly <i>a<sub>i</sub></i></b> spaces.  

To add spaces, Petya selects a line and presses one of three keys: <i>Space</i>, <i>Tab</i>, and <i>Backspace</i>. 
When you click on <i>Space</i>, one space is added to the line. When you click on <i>Tab</i>, four spaces are added to the line. 
Clicking on <i>Backspace</i> removes one space in the line.  

He wants to know what is the smallest number of keys he will have to press to add the required number of spaces to each
line. Help him!

## Input format
The first line of the input data contains a single positive integer <i>n</i> (1 ≤ <i>n</i> ≤ 10<sup>5</sup>) – the number
of lines in the file.  

Each of the following <i>n</i> lines contains a single non-negative integer <i>a<sub>i</sub></i> (0 ≤ <i>a<sub>i</sub></i> ≤ 10<sup>9</sup>) –
the number of spaces to be added to the <i>i</i>-th line of the file.

## Output format
Print one number – the minimum number of clicks to add the required number of spaces in each line.

## Example
| Input                            | Output |
|:---------------------------------|:-------|
| 5</br>1</br>4</br>12</br>9</br>0 | 8      |

## Notes
In the example, you can:
- click on Space 1 time in the first line.  
- Press Tab 1 time on the second line.  
- Press Tab 3 times on the third line.  
- Press Tab 2 times and press Space once in the fourth line.  
- Do not press anything in the fifth line.  

As a result, it turns out 1 + 1 + 3 + 3 = 8 taps. It can be proved that it is impossible to add the required number of spaces in 7 
clicks or less.
