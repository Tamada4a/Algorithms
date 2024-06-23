import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // The dimensions of the matrix will be stored in these variables
        int n = Integer.MAX_VALUE, m = Integer.MAX_VALUE;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize matrix with extra dimensions
        int[][] inputMatrix = new int[n + 2][m + 2];

        // Initialize left upper corner with 1. because only one way to reach this cell
        inputMatrix[0][0] = 1;

        // Update other cells
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                inputMatrix[i + 1][j + 2] += inputMatrix[i][j];
                inputMatrix[i + 2][j + 1] += inputMatrix[i][j];
            }
        }

        // Printing right lower corner value
        System.out.print(inputMatrix[n - 1][m - 1]);
    }
}