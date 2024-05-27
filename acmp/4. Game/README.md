# 4. Game
<i>(Time: 1 sec. Memory: 16 Mb. Difficulty: 4%)</i> 
 
In their free time, classmates Vasya and Petya like to play various logic games: naval combat, tic-tac-toe, chess, checkers and much more. 
The guys have already tried and played all kinds of classic games of this kind, including computer games. One day they wanted to play 
something new, but they couldn't find anything suitable. Then Petya came up with the following «Guessing» game: Two participants play. 
The first one guesses any three-digit number, such that the first and last digits differ from each other by more than one. Next, the player 
who made the number turns over the hidden number, swapping the first and last digits, thus getting another number. Then the minimum is 
subtracted from the maximum of the two numbers obtained. The task of the second player is to guess the number itself by the first digit 
of the number obtained as a result of subtraction. For example, if Vasya guessed the number 487, then by rearranging the first and last 
digits he will get the number 784. After which he will have to subtract the number 487 from 784, resulting in the number 297, which Petya 
must guess using the specified first digit «2» taken from this number. Petya does better than Vasya in mathematics, so he almost always 
wins in games of this type. But in this case, Petya cheated and specially came up with a game in which he would not lose to Vasya in any 
case. The fact is that the game invented by Petya has a winning strategy, which is as follows: the desired number is always three digits 
and its second digit is always nine, and to get the value of the last one, it is enough to subtract the first one from nine, i.e. in the 
case discussed above, the last digit is 9-2=7. Help Petya simplify the process of guessing a number according to its first digit by 
writing the appropriate program.
 
## Input data
In the single line of the input file INPUT.TXT a single digit K is set, corresponding to the first digit of the value obtained by 
Vasya as a result of subtracting the smallest value guessed by Vasya from the largest.

## Output data
To the output file OUTPUT.TXT it is necessary to output the value of the difference obtained by you.


## Examples
| № | INPUT.TXT | OUTPUT.TXT |
|:--|:----------|:-----------|
| 1 | 5         | 594        |
| 2 | 2         | 297        |
| 3 | 7         | 792        |