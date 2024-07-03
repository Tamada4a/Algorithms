import java.util.ArrayList;
import java.util.List;

public class RomanNumerals {
    // Declaring arrays in which Roman numerals and Arabic numerals are stored
    private static final ArrayList<String> ROMAN_NUMBERS = new ArrayList<>(
            List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    );
    private static final ArrayList<Integer> ARABIC_NUMBERS = new ArrayList<>(
            List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    );


    public static String toRoman(int n) {
        // The Roman number will be stored in this variable
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ARABIC_NUMBERS.size(); ++i) {
            // We add Roman numerals to the result, the number of which = n div arabic_num
            result.append(ROMAN_NUMBERS.get(i).repeat(n / ARABIC_NUMBERS.get(i)));

            // We update the value of the variable - now it stores the remainder of the division by the
            // corresponding Arabic number
            n %= ARABIC_NUMBERS.get(i);
        }
        return result.toString();
    }


    public static int fromRoman(String romanNumeral) {
        // The Arabic number will be stored in this variable
        int result = 0;

        // A substring will be stored in this variable
        StringBuilder seq = new StringBuilder();

        for (int i = 0; i < romanNumeral.length(); ++i) {
            // Adding the current character from the Roman number
            seq.append(romanNumeral.charAt(i));

            // If there is no such Roman number, in the previous step we found the maximum
            if (!ROMAN_NUMBERS.contains(seq.toString())) {
                // Going back to the previous number
                seq.deleteCharAt(seq.length() - 1);
                // We get the corresponding Arabic number
                result += ARABIC_NUMBERS.get(ROMAN_NUMBERS.indexOf(seq.toString()));
                // Updating the substring
                seq.setLength(0);
                seq.append(romanNumeral.charAt(i));
            }
        }

        // Adding the value of the remaining Roman number to the result
        return result + ARABIC_NUMBERS.get(ROMAN_NUMBERS.indexOf(seq.toString()));
    }
}