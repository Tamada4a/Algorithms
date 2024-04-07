import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables where the corresponding values from the file will be written
        int g11 = 0, g21 = 0, g12 = 0, g22 = 0, type = 0, goals = 0;

        // Counter for calculating the row index
        int counter = 0;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                if (counter != 2) {
                    String[] splitNumbers = scanner.nextLine().split(":");
                    if (counter == 0) {
                        g11 = Integer.parseInt(splitNumbers[0]);
                        g21 = Integer.parseInt(splitNumbers[1]);
                    } else {
                        g12 = Integer.parseInt(splitNumbers[0]);
                        g22 = Integer.parseInt(splitNumbers[1]);
                    }
                } else {
                    type = Integer.parseInt(scanner.nextLine());
                }
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Counting the goal difference
        int dif = g21 + g22 - g11 - g12;

        // If the first team goes with a gap, then the minimum number of balls needed to win is 0
        if (dif < 0) {
            System.out.print(0);
            return;
        }


        if (type == 1) {
            goals = calculateAsFirst(dif, g12, g21);
        } else {
            // If the team played the first game away and scored more goals than the opponent away in the second game -
            // the solution is the same as in the case of type 1
            if (g11 > g22)
                goals = calculateAsFirst(dif, g11, g22);
            else {
                goals = dif + 1;
            }
        }

        System.out.print(goals);
    }


    // Counting the number of goals necessary for the victory of the first team in the case of type 1
    private static int calculateAsFirst(int dif, int g12, int g21) {
        int goals = dif;

        // I the difference in away goals remains, then we correct it
        if (goals + g12 <= g21)
            goals = dif + 1;

        return goals;
    }
}
