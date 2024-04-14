import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables for recording values
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, p = Integer.MAX_VALUE;

        // The number of living enemies
        int enemies = 0;

        // Step counter
        int counter = 1;

        // The value of "y" in the previous iteration
        int yOld;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (x == Integer.MAX_VALUE) {
                    x = scanner.nextInt();
                }
                else if (y == Integer.MAX_VALUE) {
                    y = scanner.nextInt() - x;
                }
                else {
                    p = scanner.nextInt();
                    enemies = p;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // We consider the difference between the number of enemies and our army - so much HP will be taken away from the barracks
        int a = x - p;
        if (a < 0)
            a = 1;

        // If the barracks were destroyed in 1 blow, we exit the program
        if (y <= 0)
            System.out.print(1);
        else {
            int minSteps = Integer.MAX_VALUE; // The minimum number of steps in which it was possible to achieve victory

            while (enemies != 0 || y != 0) {
                yOld = y;

                int roundsToWin = calculateRoundsToWin(x, enemies, x - y);

                // We consider the data to exit the cycle with a 100% chance of winning
                int stepsRemain = x - y;
                int enemyRemain = enemies - stepsRemain;
                int soldiersRemain = x - enemyRemain;

                // We come out with a 100% victory, but not the fact that with the best result
                if (enemyRemain <= soldiersRemain) {
                    y = 0;
                    enemies = enemyRemain;

                    if (enemies < 0)
                        enemies = 0;

                    x -= enemies;
                // If the base is not demolished, we cause damage, lose army, kill opponents, the base will spawn new enemies
                } else if (y != 0) {
                    y -= a;
                    enemies -= (x - a);
                    x -= enemies;
                    enemies += p;
                // If we destroy the base, we kill the enemies, we lose our army
                } else {
                    enemies -= x;

                    if (enemies < 0)
                        enemies = 0;

                    x -= enemies;
                }
                counter += 1;

                // If we have lost our army or have not demolished the HP base, we exit the cycle
                if (x < 0 || yOld - y == 0) {
                    enemies = 0;
                    y = 0;
                }

                // Updating the minimum number of steps
                if (roundsToWin != -1 && (counter + roundsToWin < minSteps)) {
                    minSteps = roundsToWin + counter;
                }
            }
            // If the minimum number has not been updated, we output -1, otherwise the number of steps
            if (minSteps == 2147483647)
                System.out.print(-1);
            else
                System.out.print(minSteps);
        }
    }


    // Allows you to calculate how many steps are needed to win in the current scenario
    // x is the number of our troopers
    // enemies - the number of enemies
    // firstAttack - how many warriors can strike the first blow
    private static int calculateRoundsToWin(int x, int enemies, int firstAttack) {
        int counter = 0;
        while (x > 0 && enemies > 0) {
            if (counter != 0)
                enemies -= x;
            else
                enemies -= firstAttack;

            if (enemies < 0)
                enemies = 0;

            x -= enemies;

            counter += 1;
        }
        return x > 0 ? counter - 1 : -1;
    }
}