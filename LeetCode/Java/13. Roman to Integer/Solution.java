package org.example;

import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = Map.of(
                'M', 1000,
                'D', 500,
                'C', 100,
                'L', 50,
                'X', 10,
                'V', 5,
                'I', 1
        );

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = romanToIntMap.get(s.charAt(i));
            if (i < s.length() - 1 && val < romanToIntMap.get(s.charAt(i + 1))) {
                sum -= val;  // subtractive case
            } else {
                sum += val;
            }
        }
        return sum;
    }
}