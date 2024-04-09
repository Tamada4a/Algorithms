import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // This variable will store the weight of the watermelon
        int w = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            w = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print YES if the weight is even, and it is more than 2 kilograms, because out of 2 kilograms it is
        // impossible to get two parts of a watermelon that weigh an even number of kilograms
        if (w % 2 == 0 && w > 2)
            System.out.print("YES");
        // Else print NO
        else
            System.out.print("NO");
    }
}