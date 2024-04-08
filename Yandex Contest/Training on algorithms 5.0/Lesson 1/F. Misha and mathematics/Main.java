import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Line counter
        int counter = 0;

        // Number of odd numbers
        int unevenCount = 0;

        // Number of numbers
        int n = 0;

        // Indexes of even and odd numbers. Ideally, these are indexes of neighboring numbers
        int evenIdx = -1;
        int unevenIdx = -1;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (counter > 0) {
                    int curNum = scanner.nextInt();
                    if (curNum % 2 != 0) {
                        unevenCount += 1;
                        if (Math.abs(evenIdx - unevenIdx) != 1 || unevenIdx == -1 || evenIdx == -1) {
                            unevenIdx = counter - 1;
                        }
                    } else if (Math.abs(evenIdx - unevenIdx) != 1 || unevenIdx == -1 || evenIdx == -1) {
                        evenIdx = counter - 1;
                    }
                } else {
                    n = scanner.nextInt();
                }
                counter += 1;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Initialize the string with pluses
        StringBuilder combination = new StringBuilder("+".repeat(n - 1));

        // If we have an even number of odd numbers, we put multiplication in the needful place
        if (unevenCount % 2 == 0) {
            int replaceIdx;
            if (evenIdx == -1 || unevenIdx == -1)
                replaceIdx = 0;
            else
                replaceIdx = Math.min(evenIdx, unevenIdx);

            combination.setCharAt(replaceIdx, 'x');
        }

        System.out.print(combination);
    }
}
