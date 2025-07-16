package org.example;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            for (String s : strs) {
                if (i > s.length() - 1) {
                    return sb.toString();
                }

                if (s.charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
    }
}