import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int n = -1, k = -1, m = -1;

        // Reading the data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                n = Integer.parseInt(split[0]);
                k = Integer.parseInt(split[1]);
                m = Integer.parseInt(split[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Variable for answer
        int ans = 0;

        // Calculate answer until there is enough mass for the work piece
        while (n > 0 && n >= k && k >= m) {
            n -= k;
            ans += k / m;
            n += k % m;
        }
        System.out.print(ans);
    }
}