# 11. Container With Most Water
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.  

*Return the maximum amount of water a container can store.*

**Notice** that you may not slant the container.

## Example 1:
![Example](./assets/question_11.jpg)
<pre>
<b>Input:</b> height = [1,8,6,2,5,4,8,3,7]
<b>Output:</b> 49
<b>Explanation:</b> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

## Example 2:
<pre>
<b>Input:</b> height = [1,1]
<b>Output:</b> 1
</pre>

## Constraints:
- `n == height.length`
- <code>2 <= n <= 10<sup>5</sup></code>
- <code>0 <= height[i] <= 10<sup>4</sup></code>