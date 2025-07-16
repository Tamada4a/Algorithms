package org.example;

class Solution {
    public String intToRoman(int num) {
        int[] romanToInt = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanName = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            for (int i = 0; i < romanToInt.length; i++) {
                int roman = romanToInt[i];

                if (num < roman) {
                    continue;
                }

                num -= roman;
                sb.append(romanName[i]);
                break;
            }
        }

        return sb.toString();
    }
}