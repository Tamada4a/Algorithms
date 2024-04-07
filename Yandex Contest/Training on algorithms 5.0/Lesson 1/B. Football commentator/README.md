# B. Football commentator
<table>
  <tr>
      <td>Time limit</td>
      <td>2 seconds</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>64Mb</td>
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

The playoff round between the two teams consists of two matches. Each team plays one match «at home» and «away». 
The team that scores the most goals wins. If the number of goals scored matches, the team that scored more
goals «away» wins. If this number of goals matches, the match goes into an extra half or a penalty shootout.  

You are given the score of the first match, as well as the score of the current game (which has not ended yet). Help the commentator tell you how
many goals the first team needs to score in order to win, without putting the game into extra time.

## Input format
The first line contains the score of the first mast in the format <i>G<sub>1</sub>:G<sub>2</sub></i>, where <i>G<sub>1</sub></i> is the number of goals scored
by the first team, and <i>G<sub>2</sub></i> is the number of goals scored by the second team.  

The second line contains the score of the second (current) match in a similar format. All numbers in the account
record do not exceed <i>5</i>.  

The third line contains the number <i>1</i> if the first team played the first game "at home", or <i>2</i> if "away".

## Output format
Print a single integer — the required number of balls.

## Example 1
| Input              | Output |
|:-------------------|:-------|
| 0:0</br>0:0</br> 1 | 1      |

## Example 2
| Input              | Output |
|:-------------------|:-------|
| 0:2</br>0:3</br> 1 | 5      |

## Example 3
| Input              | Output |
|:-------------------|:-------|
| 0:2</br>0:3</br> 2 | 6      |
