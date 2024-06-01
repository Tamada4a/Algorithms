import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // These variables will contain the corresponding values
        int n = Integer.MAX_VALUE, m = Integer.MAX_VALUE;

        // This matrix will store the original matrix
        int[][] inputMatrix = {};

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);

            // We add 2 dimensions to each dimension, since we will use additional boundaries so as
            // not to process going beyond the boundaries of the array once again
            inputMatrix = new int[n + 2][m + 2];

            for (int i = 1; i < n + 1; ++i) {
                split = reader.readLine().split(" ");
                for (int j = 1; j < m + 1; ++j) {
                    int curNum = Integer.parseInt(split[j - 1]);
                    // We calculate the maximum weight of the path that can be reached at a given point
                    inputMatrix[i][j] = Math.max(curNum + inputMatrix[i - 1][j], curNum + inputMatrix[i][j - 1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This variable will store the path from the endpoint to the starting point
        StringBuilder answer = new StringBuilder();

        // We will fill in the path starting from the end point - the lower right corner
        int r = n, k = m;
        while (r > 0 && r != 1 || k > 0 && k != 1) {
            // If the element above the current one is greater than or equal to, then we had to go down

            // The condition is greater than or equal to due to the fact that the additional boundaries
            // of the matrix are zeros.
            // If we have a vector of zeros, we will go beyond the boundaries of the array due to the
            // equality of zeros from the boundary and zero from the input vector
            if (inputMatrix[r - 1][k] >= inputMatrix[r][k - 1]) {
                answer.append("D ");
                r -= 1;
            }
            // Otherwise, we had to move to the right
            else {
                answer.append("R ");
                k -= 1;
            }
        }
        System.out.println(inputMatrix[n][m]);
        System.out.print(answer.reverse().toString().strip());
    }
}