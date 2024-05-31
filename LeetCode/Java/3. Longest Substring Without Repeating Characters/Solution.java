import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // This variable will contain max length of substring with unique symbols
        int maxLen = 0;

        // Pointers on right and left side of substring
        int leftPointer = 0, rightPointer = 0;

        // This set will contain processed symbols
        Set<Character> characterSet = new HashSet<>();

        // Iterate until right pointer less than end of string
        while (rightPointer < s.length()) {
            char curChar = s.charAt(rightPointer);

            // If set already contains current symbol - remove processed symbols and increase left
            // pointer until current symbol didn't remove from set
            if (characterSet.contains(curChar)) {
                while (characterSet.contains(curChar)) {
                    characterSet.remove(s.charAt(leftPointer));
                    leftPointer += 1;
                }
            // Otherwise, add symbol to set and recalculate max length of substring
            } else {
                characterSet.add(curChar);
                maxLen = Math.max(maxLen, characterSet.size());
                rightPointer += 1;
            }
        }
        return maxLen;
    }
}