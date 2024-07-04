public class KataSolution {

    public static String expand(String expr) {
        // The corresponding values will be stored in these variables
        int n, a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        char letter = ' ';

        // We get the value of a, b, n and the letter of the expression
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < expr.length(); ++i) {
            if (expr.charAt(i) == '-' || isNumber(String.valueOf(expr.charAt(i)))) {
                sb.append(expr.charAt(i));
            } else if (isNumber(sb.toString()) || sb.toString().equals("-")) {
                if (sb.toString().equals("-"))
                    sb.append("1");

                if (a == Integer.MIN_VALUE) {
                    a = Integer.parseInt(sb.toString());
                    letter = expr.charAt(i);
                } else
                    b = Integer.parseInt(sb.toString());

                sb.setLength(0);
            }
        }
        // If the coefficient a == 1, then we adjust the values
        if (b == Integer.MIN_VALUE) {
            b = a;
            a = 1;
            letter = expr.charAt(1);
        }
        // We get the value of the degree
        n = Integer.parseInt(sb.toString());

        // If the coefficient b == 0, then we return the result of the expression (a*letter)^n
        if (b == 0)
            return getPolyUnit(1, n, 0, a, b, letter, true);

        // If the degree is == 0, then return 1
        if (n == 0)
            return "1";

        sb.setLength(0);

        // Otherwise, we calculate the value of each term of the polynomial using Pascal's triangle
        long nFac = getFactorial(n);
        for (int k = 0; k < n + 1; ++k) {
            // Calculate the coefficient C_n^k
            long c = nFac / (getFactorial(k) * getFactorial(n - k));

            // If the leading element is missing + before the number
            if (sb.isEmpty()) {
                sb.append(getPolyUnit(c, n, k, a, b, letter, true));
            } else
                sb.append(getPolyUnit(c, n, k, a, b, letter, false));
        }

        return sb.toString();
    }


    // The method allows you to determine whether a sequence is a number
    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // The method allows you to get the factorial of a number
    private static long getFactorial(int f) {
        long result = 1;
        for (long i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }


    // The method allows you to get a correct representation of the next term of the polynomial
    private static String getPolyUnit(long c, int n, int k, int a, int b, char letter, boolean isLead) {
        StringBuilder result = new StringBuilder();

        // We raise the coefficients a and b to the appropriate degrees
        long newA = (long) Math.pow(a, n - k);
        long newB = (long) Math.pow(b, k);

        // If the product is different from zero
        if (c * newA * newB != 0) {
            // If the coefficient of a non-leading element is positive
            if (c * newA * newB > 0 && !isLead)
                result.append("+%d".formatted(c * newA * newB));
            // If the coefficient in front of the leading element == -1
            else if (c * newA * newB == -1 && isLead)
                result.append("-");
            // If the value of the coefficient modulus is != 1 or the last element is being processed
            else if (Math.abs(c * newA * newB) != 1 || n - k == 0)
                result.append(c * newA * newB);
        }

        // Processing the display of the letter in the expression. It is present in the expression if
        // the coefficient is not zero, or it is not the last element
        if (n - k != 0 && c * newA * newB != 0) {
            // If the last element is added, add a letter without a degree
            if (n - k == 1)
                result.append(letter);
            // Otherwise, with a degree
            else
                result.append("%s^%d".formatted(letter, n - k));
        }

        return result.toString();
    }
}