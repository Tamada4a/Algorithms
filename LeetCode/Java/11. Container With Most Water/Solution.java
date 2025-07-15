package org.example;

class Solution {
    public int maxArea(int[] height) {
        int maxSum = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            int curLeft = height[left];
            int curRight = height[right];

            int min = Math.min(curLeft, curRight);
            maxSum = Math.max(maxSum, min * (right - left));

            if (curLeft == min) {
                left++;
            } else {
                right--;
            }
        }

        return maxSum;
    }
}