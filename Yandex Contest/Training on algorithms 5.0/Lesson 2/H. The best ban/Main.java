import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int n = Integer.MAX_VALUE, m = Integer.MAX_VALUE;

        // The array where we will write input matrix
        ArrayList<Integer> matrix = new ArrayList<>();

        // Maximum Element data
        int maxElem = Integer.MIN_VALUE;
        int maxIdx1 = -1;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (n == Integer.MAX_VALUE) {
                    n = scanner.nextInt();
                } else if (m == Integer.MAX_VALUE) {
                    m = scanner.nextInt();
                } else {
                    // Read the matrix and look for the maximum element
                    for (int i = 0; i < n * m; ++i) {
                        int curElem = scanner.nextInt();

                        if (curElem > maxElem) {
                            maxElem = curElem;
                            maxIdx1 = i;
                        }
                        matrix.add(curElem);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // The data for the first and second maximum, if we delete the row
        int maxElem21 = Integer.MIN_VALUE;
        int maxIdx21 = -1;
        int maxElem22 = Integer.MIN_VALUE;
        int maxIdx22 = -1;

        // Data for the first and second maximum if we delete the column
        int maxElem31 = Integer.MIN_VALUE;
        int maxIdx31 = -1;
        int maxElem32 = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.size(); ++i) {
            // We have crossed out the row and are looking for the index column and the second
            // maximum remaining after crossing out the column or located in this column
            if (i / m != maxIdx1 / m) {
                if (matrix.get(i) > maxElem21) {
                    maxElem22 = maxElem21;
                    maxIdx22 = maxIdx21;

                    maxElem21 = matrix.get(i);
                    maxIdx21 = i;
                } else if (matrix.get(i) > maxElem22 && i % m != maxIdx21 % m) {
                    maxElem22 = matrix.get(i);
                    maxIdx22 = i;
                }
            }

            // We have crossed out the column and are looking for the index of the new row and
            // the second maximum remaining after crossing out the row or remaining in this row
            if (i % m != maxIdx1 % m) {
                if (matrix.get(i) > maxElem31) {
                    maxElem32 = maxElem31;

                    maxElem31 = matrix.get(i);
                    maxIdx31 = i;
                } else if (matrix.get(i) > maxElem32 && i / m != maxIdx31 / m) {
                    maxElem32 = matrix.get(i);
                }
            }
        }

        // If we initially deleted the row and then the column and the largest number remaining
        // after the strikeouts is less than if we deleted the column and then the row
        if (maxElem22 < maxElem32)
            System.out.printf("%d %d", maxIdx1 / m + 1, maxIdx21 % m + 1);
        // If we initially deleted the column and then the row and the largest number remaining
        // after the strikeouts is less than if we deleted the row and then the column
        else if (maxElem22 > maxElem32)
            System.out.printf("%d %d", maxIdx31 / m + 1, maxIdx1 % m + 1);
        // If we have the remaining numbers after the strikeouts equal
        else {
            // If the first and second maximum have the same column after crossing out the row
            // and column
            if (maxIdx21 % m == maxIdx22 % m)
                System.out.printf("%d %d", maxIdx1 / m + 1, maxIdx21 % m + 1);
            else
                System.out.printf("%d %d", maxIdx31 / m + 1, maxIdx1 % m + 1);
        }
    }
}