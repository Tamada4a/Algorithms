import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int yMax = Integer.MAX_VALUE, yMin = Integer.MAX_VALUE, xMax = Integer.MAX_VALUE, xMin = Integer.MAX_VALUE;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String[] nextLine = scanner.nextLine().split(" ");
                // The rectangle with the minimum area will have the coordinates of the corners
                // corresponding to the largest and smallest x and y
                if (nextLine.length == 2) {
                    int x = Integer.parseInt(nextLine[0]);
                    int y = Integer.parseInt(nextLine[1]);

                    if (x > xMax || xMax == Integer.MAX_VALUE)
                        xMax = x;

                    if (x < xMin || xMin == Integer.MAX_VALUE)
                        xMin = x;

                    if (y > yMax || yMax == Integer.MAX_VALUE)
                        yMax = y;

                    if (y < yMin || yMin == Integer.MAX_VALUE)
                        yMin = y;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.printf("%d %d %d %d", xMin, yMin, xMax, yMax);
    }
}