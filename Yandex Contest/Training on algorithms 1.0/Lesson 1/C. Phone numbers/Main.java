import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // This variable will store the number that Vasya wants to record
        String targetNumber = "";

        // The numbers already recorded will be stored in this list
        ArrayList<String> existedNumbers = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (targetNumber.isEmpty()) {
                    targetNumber = convertString(line);
                } else {
                    existedNumbers.add(convertString(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // We are starting to check the existing numbers for correctness
        for (String existedNumber : existedNumbers) {
            if (expandNumber(targetNumber).equals(expandNumber(existedNumber))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // Removing all unnecessary items from the line
    private static String convertString(String line) {
        return line
                .replace("+7", "8")
                .replace("-", "")
                .replace("(", "")
                .replace(")", "");
    }

    // The method allows you to add either a code or remove the first digit of the number
    private static String expandNumber(String number) {
        if (number.length() < 11) {
            return "495" + number;
        }
        return number.substring(1);
    }
}