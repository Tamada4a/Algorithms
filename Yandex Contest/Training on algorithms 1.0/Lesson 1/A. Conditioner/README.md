# A. Conditioner

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

A new type of air conditioner was installed in the office where programmer Peter works. This air conditioner is particularly easy to operate. The air conditioner has only two controllable parameters: the desired temperature 
and the operating mode. The air conditioner can operate in the following four modes:  

«freeze» — cooling. In this mode, the air conditioner can only reduce the temperature. If the temperature in the room is no higher than desired, then it turns off.  

«heat» — heating. In this mode, the air conditioner can only increase the temperature. If the temperature in the room is not less than desired, then it turns off.  

«auto» — automatic mode. In this mode, the air conditioner can both increase and decrease the temperature in the room to the desired one.  

«fan» — ventilation. In this mode, the air conditioner only ventilates the air and does not change the temperature in the room.  

The air conditioner is powerful enough, so when set to the correct operating mode, it brings the temperature in the room to the desired temperature in an hour.  

You need to write a program that, based on the set temperature in the room *t<sub>room</sub>*, the desired temperature *t<sub>cond</sub>* setted on the air conditioner and the operating mode, determines the temperature 
that will be set in the room in an hour.

## Input format
The first line of the input file contains two integers *t<sub>room</sub>*, and *t<sub>cond</sub>*, separated by exactly one space (-50 ≤ *t<sub>room</sub>* ≤ 50, -50 ≤ *t<sub>cond</sub>* ≤ 50).  

The second line contains one word written in lowercase letters of the Latin alphabet — the mode of operation of the air conditioner.

## Output format
The output file must contain a single integer — the temperature that will be set in the room in an hour.

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
        10 20</br>
        heat
      </td>
      <td>
        20
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
        10 20</br>
        freeze
      </td>
      <td>
        10
      </td>
    </tr>
  </tbody>
</table>

## Notes
In the first example, the air conditioner is in heating mode. After an hour, he will heat the room to the desired temperature of 20 degrees.  

In the second example, the air conditioner is in cooling mode. Since the temperature in the room is lower than desired, the air conditioner turns off on its own and the temperature in the room will not change.