public class Maskify {
    // The function allows you to calculate the mask for a string
    public static String maskify(String str) {
        int strLen = str.length();

        // If string length is less than 5 we return input string
        if (strLen < 5)
            return str;

        // Otherwise, we create a string consisting of (strLen - 4) characters "#"
        StringBuilder answer = new StringBuilder("#".repeat(strLen - 4));

        // Adding the last 4 characters from input string to the end of the answer string
        for (int i = 4; i > 0; --i)
            answer.append(str.charAt(strLen - i));

        return answer.toString();
    }
}