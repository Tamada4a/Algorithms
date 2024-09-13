import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        char[] nickAsChar = {};

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            nickAsChar = reader.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isUpperCaseLetter = false;
        boolean isLowerCaseLetter = false;
        boolean isDigit = false;

        for (char c : nickAsChar) {
            if (Character.isDigit(c))
                isDigit = true;
            else if (c == Character.toUpperCase(c))
                isUpperCaseLetter = true;
            else if (c == Character.toLowerCase(c))
                isLowerCaseLetter = true;
        }

        if (isUpperCaseLetter && isLowerCaseLetter && isDigit && nickAsChar.length > 7)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}