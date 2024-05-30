public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
        // This variable will contain current accumulated sequence of bits
        StringBuilder curBitsSeq = new StringBuilder();

        // This variable will contain time unit size
        int timeUnit = Integer.MAX_VALUE;

        // This variable will contain index of the end of the leading zeros sequence
        int startZerosEnds = Integer.MIN_VALUE;

        // This variable will contain index of the start of the ending zeros sequence
        int endZerosStarts = Integer.MAX_VALUE;

        // In this loop we'll calculate time unit size and indexes of leading and ending zeros sequences
        for (int i = 0; i < bits.length(); ++i) {
            char curChar = bits.charAt(i);
            // If we meet different symbol
            if (!curBitsSeq.isEmpty() && curChar != curBitsSeq.charAt(curBitsSeq.length() - 1)) {
                // Update end of the leading zeros sequence
                if (timeUnit == Integer.MAX_VALUE && bits.charAt(i - 1) == '0')
                    startZerosEnds = i;

                // Update time unit size if we have not leading zeros sequence
                if (bits.charAt(i - 1) != '0' || timeUnit != Integer.MAX_VALUE)
                    timeUnit = Math.min(curBitsSeq.length(), timeUnit);

                // Reset current bits sequence
                curBitsSeq.setLength(0);
            }
            curBitsSeq.append(curChar);
        }
        // If needed, update index of the start of the ending zeros sequence
        if (curBitsSeq.charAt(curBitsSeq.length() - 1) == '0')
            endZerosStarts = bits.length() - curBitsSeq.length();

        // If time unit size is unchanged, set the time unit size as current bits sequence
        if (timeUnit == Integer.MAX_VALUE)
            timeUnit = curBitsSeq.length();

        // Reset current bits sequence for next loop
        curBitsSeq.setLength(0);

        // This variable will contain Morse Code (decoded input bits sequence)
        StringBuilder morseCode = new StringBuilder();

        // Start loop from end of leading zeros sequence (otherwise - start from 0)
        // The loop is running until i smaller than start of the ending zeros sequence (otherwise - until bits.length())
        for (int i = Math.max(0, startZerosEnds); i < Math.min(bits.length(), endZerosStarts); ++i) {
            char curChar = bits.charAt(i);
            // If we meet different symbol and bits sequence has correct length
            if (!curBitsSeq.isEmpty() && curChar != curBitsSeq.charAt(curBitsSeq.length() - 1) && checkSeqLen(curBitsSeq, timeUnit)) {
                // Update Morse Code
                morseCode.append(getCorrectSym(curBitsSeq, timeUnit));
                curBitsSeq.setLength(0);
            }
            curBitsSeq.append(curChar);
        }
        // Update Morse Code with last bits sequence
        morseCode.append(getCorrectSym(curBitsSeq, timeUnit));
        return morseCode.toString().strip();
    }


    // Checking the correctness of the bits sequence length
    // Correct length is: 1 time unit, 3 time unit, 7 time unit (as in the task condition)
    private static boolean checkSeqLen(StringBuilder curBitsSeq, int timeUnit) {
        return curBitsSeq.length() == timeUnit || curBitsSeq.length() == 3 * timeUnit || curBitsSeq.length() == 7 * timeUnit;
    }


    // Decode bits sequence as dash or dot
    private static String getCorrectSym(StringBuilder curBitsSeq, int timeUnit) {
        if (curBitsSeq.length() == 0)
            return "";

        char lastSym = curBitsSeq.charAt(curBitsSeq.length() - 1);
        if (lastSym == '1') {
            if (curBitsSeq.length() == timeUnit)
                return ".";

            return "-";
        }

        if (curBitsSeq.length() == timeUnit)
            return "";

        if (curBitsSeq.length() == 3 * timeUnit)
            return " ";

        return "   ";
    }



    // Solution from here: https://github.com/Tamada4a/Algorithms/tree/main/Codewars/Decode%20the%20Morse%20code
    public static String decodeMorse(String morseCode) {
        // This variable will contain decoded string
        StringBuilder stringBuilder = new StringBuilder();

        // Split input Morse Code by triple spaces - split words
        String[] splitMorseCode = morseCode.strip().split("   ");

        // For each word
        for (String code : splitMorseCode) {
            // Split word by space - get array of symbols
            String[] splitCode = code.split(" ");

            // Decode each symbol
            for (String sym : splitCode) {
                stringBuilder.append(MorseCode.get(sym));
            }
            // Appending space between words
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().strip();
    }
}