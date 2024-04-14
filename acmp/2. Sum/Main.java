import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // This variable store thr right border of number series
        int n = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Counting sum
        int sum = 0;
        for (int i = 1; i <= Math.abs(n); ++i) {
            sum += i;
        }

        // If n is less than 1, we change the sign of the sum and add 1.
        // The sign change is relevant for negative n, and the addition of 1 is used for 0
        // and negative numbers
        if (n < 1)
            sum = -1 * sum + 1;

        System.out.print(sum);
    }
}