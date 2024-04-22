# 1. Two Sum
Given an array of integers `nums` and an integer `target`, return <i>indices of the two numbers such that they add up to `target`</i>.  

You may assume that each input would have <b><i>exactly</i> one solution</b>, and you may not use the <i>same</i> element twice.  

You can return the answer in any order.  

## Example 1:
<pre>
<b>Input:</b> nums = [2,7,11,15], target = 9
<b>Output:</b> [0,1]
<b>Explanation:</b> Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

## Example 2:
<pre>
<b>Input:</b> nums = [3,2,4], target = 6
<b>Output:</b> [1,2]
</pre>

## Example 3:
<pre>
<b>Input:</b> nums = [3,3], target = 6
<b>Output:</b> [0,1]
</pre>

## Constraints:
- <code>2 <= nums.length <= 10<sup>4</sup></code>
- <code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code>
- <code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code>
- <b>Only one valid answer exists.</b>

## Follow-up: 
Can you come up with an algorithm that is less than <code>O(n<sup>2</sup>)</code> time complexity?