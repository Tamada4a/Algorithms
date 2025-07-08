package org.example;


class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        long res = 0;

        boolean isNegative = false;
        boolean isSignCanBeDetermined = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isSignCanBeDetermined && (c == '+' || c == '-')) {
                isSignCanBeDetermined = false;
                isNegative = c == '-';
            } else if (c >= '0' && c <= '9') {
                isSignCanBeDetermined = false;
                res = res * 10 + (c - '0');
                if (res > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }

        if (isNegative) {
            res = res * -1;
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) res;
    }
}