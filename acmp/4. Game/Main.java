import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // This variable will store the entered number
        int k = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            k = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // As we know, K is the first in the number - so multiply by 100.
        // There is a 9 in the middle - add 90.
        // At the end, add the difference between 9 and K
        int result = k * 100 + 90 + 9 - k;

        System.out.print(result);
    }
}