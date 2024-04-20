import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            c = Integer.parseInt(split[2]);
            d = Integer.parseInt(split[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // We put the cost of the tariff in answer
        int ans = a;

        // If you plan to use more traffic than in the tariff, we consider the overpayment
        if (d > b) {
            ans += (d - b) * c;
        }
        System.out.print(ans);
    }
}