import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // This variable will store the entered number
        int n = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Executing the algorithm:
        // 1. We delete the last digit from the number - five
        int div = n / 10;
        // 2. Multiply the number by the following and add 25 to the end
        // Multiply by 100, because you need to add 25 to the end of the number, and this is a
        // two-digit number. Multiplying by 100, we add two digits to the resulting number
        long result = (long) div * (div + 1) * 100 + 25;

        System.out.print(result);
    }
}