import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // A list where all the numbers corresponding to the number of spaces in the i-th line will be written
        ArrayList<Integer> listOfSpaces = new ArrayList<>();

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                listOfSpaces.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // In this array, an additional number of operations is recorded for each remainder of the division by 4.
        // The index in the array is the remainder of dividing by 4 the number of spaces in the i-th line
        int[] modPairArr = {0, 1, 2, 2};

        // Let's sum up the number of operations
        long sum = 0;
        if (listOfSpaces.size() > 0) {
            for (int i = 1; i < listOfSpaces.get(0) + 1; ++i) {
                sum += listOfSpaces.get(i) / 4 + modPairArr[listOfSpaces.get(i) % 4];
            }
        }

        System.out.print(sum);
    }
}
