package org.example;

import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();

        if (numRows <= 1 || length <= numRows) {
            return s;
        }

        ArrayList<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }

        boolean isReversed = true;
        int curRow = 0;
        for (int i = 0; i < length; i++) {
            // If we reach the end of the column, then we go diagonally back until we reach the beginning of the next column.
            if (curRow == numRows - 1 || curRow == 0) {
                isReversed = !isReversed;
            }

            result.get(curRow).append(s.charAt(i));

            if (isReversed) {
                curRow -= 1;
            } else {
                curRow += 1;
            }
        }

        return String.join("", result);
    }
}