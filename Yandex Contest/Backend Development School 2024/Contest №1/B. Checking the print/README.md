# B. Checking the print
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

Winter holidays... A wonderful time, full of a sense of magic, fun games outside in the snow and other children's joys. But not for Vasya. Vasya comes up with startups. 
And now he had a new idea — to make his own keyboard simulator!  

Vasya sat down and began to write code.  

Vasya worked hard all day and night. And so, the prototype is almost finished, except for one small detail.  

The simulator consists of a series of tasks: a request to the user to type some string *a*.  

After that, the user should type the line *a* on the screen as quickly as possible, using only Latin letters and control keys.  

Vasya decided to record all user keystrokes in a separate log. It contains small Latin letters as well as control structures:
- \<delete\> Deleting a character after the current cursor position.
- \<bspace\> Deleting a character before the current cursor position.
- \<left\> The cursor moves one character to the left.
- \<right\> The cursor moves one character to the right.

If the control construct moves the cursor beyond the boundaries of the current line or tries to delete a non-existent character, then nothing happens.  

Now Vasya has a line that the user should have typed, and a sequence of keystrokes read from the log.  

Help Vasya find out if the user has completed the task!

## Input format
Two lines *a* and *b* are given, separated by a line feed, — the user's task and the sequence of keystrokes (1 ≤ |*a*|, |*b*| ≤ 1000).

## Output format
If the user has completed the task, print "Yes" (without quotes), otherwise print "No".

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
        hellochild</br>
        helto<left><bspace>l<delete>ochilds<bspace>
      </td>
      <td>
        Yes
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
        programming</br>
        programming<left><left><right><delete>
      </td>
      <td>
        No
	</br>
      </td>
    </tr>
  </tbody>
</table>