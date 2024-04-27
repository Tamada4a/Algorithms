import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int N = Integer.MAX_VALUE;

        // Creating an array with barriers so as not to make extra checks for going beyond the borders
        int[][] chessDesk = new int[10][10];

        // The perimeter of the figure
        int p = 0;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (N == Integer.MAX_VALUE)
                    N = scanner.nextInt();
                else {
                    int i = scanner.nextInt();
                    int j = scanner.nextInt();
                    // We add 4 free sides to the current cell
                    chessDesk[i][j] += 4;

                    // Increasing the perimeter value
                    p += chessDesk[i][j];

                    // For each potential neighbor cell, we reduce the perimeter by two,
                    // that is, in this way we do not take into account the common side of
                    // the two cells in the perimeter
                    chessDesk[i - 1][j] -= 2;
                    chessDesk[i + 1][j] -= 2;
                    chessDesk[i][j - 1] -= 2;
                    chessDesk[i][j + 1] -= 2;
                }
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(p);
    }
}