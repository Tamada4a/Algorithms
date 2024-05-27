# 3. Five times five is twenty-five!
<i>(Time: 1 sec. Memory: 16 Mb. Difficulty: 8%)</i> 
 
Vasya and Petya are in the same class at school. Recently, Petya told Vasya about a clever way to square natural numbers ending in the number 5. 
Now Vasya can easily square two-digit (and even some three-digit) numbers ending in 5. The method is as follows: to square a number ending in 5, 
it is enough to multiply the number obtained from the original by crossing out the last five to the next number in order, then it remains only 
to attribute «25» to the resulting result on the right. For example, in order to square the number 125, it is enough to multiply 12 by 13 and 
assign 25, i.e. attributing the number 25 to the number 12\*13=156, we get the result 15625, i.e. 125<sup>2</sup>=15625. Write a program 
that squares a number ending in 5 so that Vasya can test his skills.
 
## Input data
In the single line of the input file INPUT.TXT there is one natural number A, ending in the digit 5, not exceeding 4\*10<sup>5</sup>.

## Output data
To the output file OUTPUT.TXT print one natural number - A<sup>2</sup> without leading zeros.


## Examples
| № | INPUT.TXT | OUTPUT.TXT |
|:--|:----------|:-----------|
| 1 | 5         | 25         |
| 2 | 75        | 5625       |
| 3 | 4255      | 18105025   |