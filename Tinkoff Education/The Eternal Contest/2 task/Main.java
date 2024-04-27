import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // The corresponding value will be stored in this variable
        int n = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize the prev and cur number of cuts as N - 1 (this is the maximum number of cuts)
        int prev = n - 1, cur = n - 1;

        // We cut the pie into two parts in advance. The largest part of the pie is stored in the div
        int curCuts = 1, div = n - n / 2;

        // Iterate until the current answer is bigger than the past
        while (cur <= prev) {
            prev = cur;

            // We count the number of cuts in the current iteration as N - 1 + the number of cuts
            cur = div - 1 + curCuts;

            // We increase the number of cuts by 1, because each time we line up the pieces of
            // the pie and cut them all at once
            curCuts += 1;

            // Recalculating the maximum part of the pie
            div = div - div / 2;
        }

        // We output the previous result, as it will be the best
        System.out.print(prev);
    }
}