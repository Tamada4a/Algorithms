# G. Destroy the barrack
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

You are playing an interesting strategy game. Your opponent has only one barrack left — a building in which new
soldiers are constantly appearing. Before the attack, you have <i>x</i> soldiers. In one round, each soldier can kill one of the enemy's 
soldiers or inflict 1 damage point to the barracks (subtract the health unit from the barracks). Initially, your opponent has no soldiers. 
However, his barracks has <i>y</i> health units and produces <i>p</i> soldiers per round.
The course of one round:
  1. Each soldier from your army either kills one of your opponent's soldiers or deals 1 point of damage to the barracks. Each soldier
can choose his own action. When the barracks loses all its health units, it collapses.
  2. Your opponent is attacking. He will kill <i>k</i> of your soldiers, where <i>k</i> is the number of remaining enemy soldiers.
  3. If the barracks have not been destroyed yet, your opponent produces <i>p</i> new soldiers.

Your task is to destroy the barracks and kill all the enemy soldiers. If possible, calculate the minimum number of rounds
you need to do this. Otherwise, print -1.

## Input format
Three integers are input <i>x</i>, <i>y</i>, <i>p</i> (1 ≤ <i>x</i>, <i>y</i>, <i>p</i> ≤ 5000) — the number of your
soldiers at the start of the game, the number of health points of the barracks and the number of soldiers produced per round by the barracks, 
respectively. Each number is placed in a new row.

## Output format
If it is possible to kill all enemy soldiers and destroy the barracks, output the minimum number of rounds needed to do this. 
Otherwise, print -1.

## Example 1
| Input            | Output |
|:-----------------|:-------|
| 10</br>11</br>15 | 4      |

## Example 2
| Input         | Output |
|:--------------|:-------|
| 1</br>2</br>1 | -1     |

## Example 3
| Input         | Output |
|:--------------|:-------|
| 1</br>1</br>1 | 1      |

## Notes
In the first example, in the first round, first all your soldiers attack the barracks, after that nothing happens because the
enemy has no soldiers, then the enemy has 15 soldiers. In the second round, one of your soldiers finishes off the barracks, the other 9 soldiers
kill 9 enemy soldiers. The remaining 6 enemy soldiers kill 6 of your soldiers, but the enemy army is not replenished because the barracks
is destroyed. In the third round, first you kill four enemy soldiers, then the enemy kills two of your soldiers. In the last, fourth
round, you finish off the two remaining enemy soldiers.
