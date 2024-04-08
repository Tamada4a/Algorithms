import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder n = new StringBuilder();
        int k = 0, d = 0, counter = 0;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                switch (counter) {
                    case 0 -> n = new StringBuilder(String.valueOf(scanner.nextInt()));
                    case 1 -> k = scanner.nextInt();
                    case 2 -> d = scanner.nextInt();
                }
                counter += 1;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // Declaring a variable that will store the last added character
        String lastSymbol = "";
        for (int i = 0; i < d; ++i) {
            // A variable containing information about whether it was possible to add a digit in the current iteration
            boolean isChanged = false;

            // In the loop, add the numbers to the end
            for (int j = 0; j < 10 && !isChanged; ++j) {
                String newN = n.toString() + j;

                if ((Double.parseDouble(newN) % k) == 0) {
                    isChanged = true;
                    n = new StringBuilder(newN);
                    lastSymbol = String.valueOf(j);
                }
            }

            // If nothing has been added, exit and return -1
            if (!isChanged) {
                n = new StringBuilder("-1");
                break;
            }

            // If the last character was 0, it means that there is no point in continuing further work and you can just
            // fill in the remaining digits with the required number of zeros
            if (lastSymbol.equals("0")) {
                n = new StringBuilder(n + "0".repeat(d - i - 1));
                break;
            }
        }
        System.out.print(n);
    }
}
