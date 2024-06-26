# A. Playlists
<table>
  <tr>
      <td>Time limit</td>
      <td>1.5 seconds</td>
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

Kostya successfully passed the interview and got an internship in the development department of the «Music» service.  

Specifically, he was assigned such a task — to learn how to select a playlist for a group of friends, relatives or colleagues. At the same time, 
you need to choose a playlist that includes songs that are exclusively liked by all members of the group.  

Kostya really wanted to complete this task quickly and efficiently, but he does not succeed. Help him write a program that makes a playlist for 
a group of people.

## Input format
The first line contains one natural number <i>n</i> (1 ≤ <i>n</i> ≤ 2·10<sup>5</sup>), where <i>n</i> is the number of members in the group.  

The following 2·<i>n</i> lines describe the favorite playlists of the group members. 2 lines for each member.  

The first of these 2 lines contains the number <i>k<sub>i</sub></i> - the number of favorite tracks <i>i</i> of the group member.  

The next line contains <i>k<sub>i</sub></i> lines separated by a space — the names of favorite tracks <i>i</i> of the group member.  

Each track in the playlist is set as a string, all strings are unique, the sum of the string lengths does not exceed 2·10<sup>6</sup>. The 
strings contain large and small Latin letters and numbers.

## Output format
Print the number, and then the list of songs separated by a space — a list of tracks that each member of the group likes. The answer must be 
<b>sorted</b> in lexicographical order!

## Example 1
| Input                    | Output             |
|:-------------------------|:-------------------|
| 1</br>2</br>GoGetIt Life | 2</br>GoGetIt Life |

## Example 2
| Input                                        | Output     |
|:---------------------------------------------|:-----------|
| 2</br>2</br>Love Life</br>2</br>Life GoodDay | 1</br>Life |
