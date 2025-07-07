package org.example;

class Solution {
    /**
     * This function searches for the longest palindrome using the Manacher's algorithm.
     */
    public String longestPalindrome(String s) {
        // Получаем измененную строку
        s = performStringBeforeSearch(s);

        int n = s.length();
        int[] d = new int[n];

        // Center and radius or rightmost palindrome
        int c = 0, r = 0;

        // The center and radius of the longest palindrome
        int bestI = 0, bestJ = 0;

        for (int i = 0; i < n; i++) {
            // We impose restrictions on borders
            int j = i > c + r ? 0 : Math.min(d[2 * c - i], c + r - i);

            while (i > j && i + j < n - 1 && s.charAt(i - j - 1) == s.charAt(i + j + 1)) {
                j += 1;
            }

            d[i] = j;

            // Updating the values of the best values
            if (j > bestJ) {
                bestI = i;
                bestJ = j;
            }

            // Updating the center and radius values
            if (i + j > c + r) {
                c = i;
                r = j;
            }
        }

        // We get the longest palindrome.
        String res = s.substring(bestI - bestJ, bestI + bestJ + 1);

        // Removing the added separators
        StringBuilder processed = new StringBuilder();
        for (int i = 1; i < res.length(); i += 2) {
            processed.append(res.charAt(i));
        }

        return processed.toString();
    }

    /**
     * This function adds additional delimiters between characters so as not to divide the algorithm into processing
     * strings of even and odd length.
     */
    public String performStringBeforeSearch(String s) {
        StringBuilder processed = new StringBuilder("|");
        for (char c : s.toCharArray()) {
            processed.append(c).append("|");
        }

        return processed.toString();
    }
}