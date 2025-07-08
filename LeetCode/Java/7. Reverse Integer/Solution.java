package org.example;


class Solution {
    public int reverse(int x) {
        // If we get 0 as input, then we return 0, because otherwise we will get an error when calculating pow.
        if (x == 0) {
            return 0;
        }

        // We memorize the sign and work only with a positive number.
        boolean isNegative = x < 0;
        x = Math.abs(x);

        // We get the number of characters in the number and subtract 1 to get the maximum power.
        int pow = (int) Math.floor(Math.log10(x) + 1) - 1;

        // We store it in a Long so that overflow can be tracked.
        long res = 0;
        while (x != 0) {
            res += (long) ((x % 10) * Math.pow(10, pow));

            // If we encounter an overflow, we exit.
            if (res > Integer.MAX_VALUE) {
                return 0;
            }

            pow -= 1;
            x /= 10;
        }

        return isNegative ? -1 * (int) res : (int) res;
    }
}