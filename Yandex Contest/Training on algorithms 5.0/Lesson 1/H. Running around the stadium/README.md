# H. Running around the stadium
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
      <td>standart input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standart output or output.txt</td>
  </tr>
</table>

The stadium is a circle <b>with a length <i>L</i></b> meters, on which the starting point is marked. Kirill and Anton are running around the stadium. 
Each boy has his own starting point (it represents the distance in meters from the start, counted clockwise) and his own speed in meters per second 
(positive speed means that the boy is running clockwise, negative — that he is running counterclockwise, and zero — that he is standing still). 
You need to tell the minimum time after which the boys will be at the same distance from the starting point. Please note that they could have been 
at different points at that moment. The distance from point <i>A</i> to point <i>B</i> is the minimum distance that you need to run from point 
<i>A</i> clockwise or counterclockwise to get to <i>B</i>.

## Input format
5 integers are entered in a single line <i>L</i>, <i>x<sub>1</sub></i>, <i>v<sub>1</sub></i>, <i>x<sub>2</sub></i>, <i>v<sub>2</sub></i> 
(1 ≤ <i>L</i> ≤ 10<sup>9</sup>, 0 ≤ <i>x<sub>1</sub></i>, <i>x<sub>2</sub></i> < <i>L</i>, <i>v<sub>1</sub></i>, <i>v<sub>2</sub></i> ≤ 10<sup>9</sup>) 
— the length of the stadium in meters, Kirill's starting point, Kirill's speed, Anton's starting point, Anton's speed.

## Output format
In the first line, print the word «YES» if there is a moment when the boys will be at the same distance from the start, or «NO» if there is no such moment.  

If the answer is «YES», then print one real number in the second line — after what minimum amount of time the boys will be at the same distance from the start.  

You can output each letter in any case (lowercase or uppercase). For example, the strings «yEs», «yes», «Yes» and «YES» will be accepted as a positive response.  

Your answer will be considered correct if its absolute or relative error does not exceed 10<sup>-9</sup>.  

Formally, let your answer be <i>a</i>, and the jury's answer is <i>b</i>. Your answer will be counted if and only if $\Large\frac{|a−b|}{max(1, |b|)}$ ≤ 10<sup>-9</sup>.  

## Example 1
| Input     | Output               |
|:----------|:---------------------|
| 6 3 1 1 1 | YES</br>1.0000000000 |

## Example 2
| Input        | Output               |
|:-------------|:---------------------|
| 12 8 10 5 20 | YES</br>0.3000000000 |

## Example 3
| Input     | Output               |
|:----------|:---------------------|
| 5 0 0 1 2 | YES</br>2.0000000000 |

## Example 4
| Input       | Output               |
|:------------|:---------------------|
| 10 7 -3 1 4 | YES</br>0.8571428571 |

## Notes
In the first test, Kirill is initially at point 3 and runs clockwise at a speed of 1. Anton is at point 1 and 
also runs clockwise at a speed of 1. After 1 second, the boys will be at points 4 and 2, respectively. Both of these points 
are located at a distance of 2 meters from the start (point 0 coinciding with point 6). It can be shown that before that they 
were always at different distances from the start. So the answer is 1.  

In the second test, both boys will be at point 11 in 0.3 seconds.  

In the third, Anton will run to Kirill at point 0 in 2 seconds.  
