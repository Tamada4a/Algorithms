# C. Phone numbers

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

Phone numbers in the address book of a mobile phone have one of the following formats: +7<code><number>, 8<code><number>, <number>, where <number> is seven digits, 
and <code> is three digits or three digits in parentheses. If the code is not specified, it is assumed that it is equal to 495. In addition, there may be a "-" sign 
between any two digits in the phone number record (see the example).  

At the moment, there are only three phone numbers in Vasya's phone address book, and he wants to write another one there. But he can't figure out if such a number is 
already recorded in the phone book. Help him! Two phone numbers are the same if they have the same codes and the same numbers. For example, +7(916)0123456 and 89160123456 
are the same number.

## Input format
The first line of the input data contains the phone number that Vasya wants to add to his phone's address book. The next three lines contain three phone numbers that are 
already in the address book of Vasya's phone. It is guaranteed that each of the records corresponds to one of the three formats specified in the condition.

## Output format
For each phone number in the address book, print YES (in capital letters) if it matches the phone number that Vasya wants to add to the address book, or NO (in capital letters) 
otherwise.

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
        8(495)430-23-97</br>
		+7-4-9-5-43-023-97</br>
		4-3-0-2-3-9-7</br>
		8-495-430
      </td>
      <td>
        YES</br>
		YES</br>
		NO</br>
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
        86406361642</br>
		83341994118</br>
		86406361642</br>
		83341994118
      </td>
      <td>
        NO</br>
		YES</br>
		NO</br>
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
        +78047952807</br>
		+78047952807</br>
		+76147514928</br>
		88047952807
      </td>
      <td>
        YES</br>
		NO</br>
		YES</br>
      </td>
    </tr>
  </tbody>
</table>