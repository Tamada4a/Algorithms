import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int N = Integer.MAX_VALUE;

        int max = 0;
        int sum = 0;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (N == Integer.MAX_VALUE)
                    N = scanner.nextInt();
                else {
                    // We calculate the sum and maximum of the input array
                    int part = scanner.nextInt();
                    max = Math.max(part, max);
                    sum += part;
                }
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        int dif = sum - max;
        // If the difference between the sum of all elements and the maximum is less than the maximum,
        // there is one whole rope and parts of the cut one on the table. So it is necessary to find the
        // remaining part
        if (dif < max)
            System.out.print(max - dif);
        // Otherwise, there are only parts of one rope on the table and the whole rope was taken away.
            // Therefore, it is necessary to find the length of the whole rope
        else
            System.out.print(sum);
    }
}