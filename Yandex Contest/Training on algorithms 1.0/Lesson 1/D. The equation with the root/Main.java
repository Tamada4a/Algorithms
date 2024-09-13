import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (a == Integer.MAX_VALUE) {
                    a = Integer.parseInt(line);
                } else if (b == Integer.MAX_VALUE) {
                    b = Integer.parseInt(line);
                } else {
                    c = Integer.parseInt(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculating the answer
        if (c < 0) {
            System.out.print("NO SOLUTION");
        } else if ((a + b) == c * c && (2 * a + b) == c * c) {
            System.out.print("MANY SOLUTIONS");
        } else {
            if (a != 0 && (float)(c * c - b) / a == (float)Math.floorDiv((c * c - b), a)) {
                System.out.print(Math.floorDiv((c * c - b), a));
            } else {
                System.out.print("NO SOLUTION");
            }
        }
    }
}