import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables where the corresponding values from the file will be written
        int p = 0, v = 0, q = 0, m = 0;

        // Counter for calculating the row index
        int counter = 0;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String[] splitNumbers = scanner.nextLine().split(" ");
                if (counter == 0) {
                    p = Integer.parseInt(splitNumbers[0]);
                    v = Integer.parseInt(splitNumbers[1]);
                } else {
                    q = Integer.parseInt(splitNumbers[0]);
                    m = Integer.parseInt(splitNumbers[1]);
                }
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Counting the boundaries of the segments
        int difp1 = p - v, difp2 = p + v, difq1 = q - m, difq2 = q + m;


		// Depending on the boundaries of the segments obtained, we rearrange the segments, if necessary, in order to reduce everything 
		// to three cases:
        // 1) a, b, c, d
        // 2) a, c, b, d
        // 3) a, c, d, b
        // where "a" and "b" are the beginning and end of the segment with the smallest position of the tree, and "c" and "d" 
		// are the remaining boundaries
        if (difp1 < difq1) {
            System.out.print(calculate(difp1, difp2, difq1, difq2));
        } else {
            System.out.print(calculate(difq1, difq2, difp1, difp2));
        }
    }


    private static int calculate(int a, int b, int c, int d) {
        int dif = 0;

        // Calculate the number of intersecting elements between the segments
        if (b > c && b > d) {
            dif = d - c + 1;
        } else if (b >= c && b < d) {
            dif = b - c + 1;
        }

        // Returning the number of painted trees
        return b - a + d - c - dif + 2;
    }
}
