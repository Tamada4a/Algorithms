import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // The corresponding value will be stored in this variable
        long n = Long.MAX_VALUE;

        // Reading the data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (n == Long.MAX_VALUE)
                    n = Long.parseLong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(rBinSearch(n));
    }

    // We implement a right-hand binary search
    private static long rBinSearch(long n) {
        long l = 0, r = n;
        while (l < r) {
            long middle = (r + l + 1) / 2;
            if (checkK(middle, n))
                l = middle;
            else
                r = middle - 1;
        }
        return l;
    }

    // A function for checking k for correctness
    private static boolean checkK(long k, long n) {
        // We create a variable from which we will subtract the occupied cells
        long dif = n;

        // We keep the starting value of k
        long startK = k;

        // The counter of the placed ships
        long counter = 0;
        while (k > 0) {
            // Counting the number of ships placed in the current iteration
            counter += (startK - k + 1);

            // Counting the number of occupied cells
            dif -= (startK - k + 1) * k;

            // Early exit from the function. If there is no room left for ships now, we go out
            if (dif < 0)
                return false;

            k -= 1;
        }
        // Subtract the number of spaces between the ships
        dif -= counter - 1;

        // If there are still places left or we have placed them side by side - true. Otherwise, false
        return dif >= 0;
    }
}