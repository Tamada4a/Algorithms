import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int n = Integer.MAX_VALUE;

        // In this HashMap, the row number will be used as the keys, and the ship that is there
        // will be used as the value
        HashMap<Integer, Pair> filledCells = new HashMap<>();

        // The array contains data on the positions of all ships
        ArrayList<Pair> shipsCoordinate = new ArrayList<>();

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (n == Integer.MAX_VALUE) {
                    n = scanner.nextInt();
                    for (int i = 1; i < n + 1; ++i) {
                        filledCells.put(i, null);
                    }
                } else
                    shipsCoordinate.add(new Pair(scanner.nextInt(), scanner.nextInt()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Sorting in ascending order of columns
        shipsCoordinate.sort(Comparator.comparing(o -> o.y));

        // Finding the median column
        int middle = shipsCoordinate.size() / 2;
        int medianCol = shipsCoordinate.get(middle).y;
        if (shipsCoordinate.size() % 2 == 0)
            medianCol = (medianCol + shipsCoordinate.get(middle - 1).y) / 2;

        // Counting the number of moves in order to rearrange the farthest ships in the median column
        int stepsToWin = 0;
        ArrayList<Pair> shipsToFix = new ArrayList<>();
        for (Pair ship : shipsCoordinate) {
            // If there is a ship at the intersection of this row and the median column
            if (filledCells.get(ship.x) != null) {
                // We are trying to take the farthest ship
                if (filledCells.get(ship.x).y != medianCol &&
                        Math.abs(medianCol - filledCells.get(ship.x).y) < Math.abs(medianCol - ship.y)
                        || Math.abs(medianCol - ship.y) == 0) {
                    stepsToWin += Math.abs(medianCol - ship.y) - Math.abs(medianCol - filledCells.get(ship.x).y);
                    shipsToFix.add(filledCells.get(ship.x));
                    filledCells.replace(ship.x, ship);
                }
                // Otherwise, we add it to the list of ships, which will then need to be distributed
                // along the lines
                else
                    shipsToFix.add(ship);
            }
            // If there is nothing at the intersection, we count the number of moves required to move
            // the ship to the median column
            else {
                stepsToWin += Math.abs(medianCol - ship.y);
                filledCells.replace(ship.x, ship);
            }
        }

        // We add the number of moves needed to arrange the remaining ships
        stepsToWin += calculateStepsToWin(filledCells, shipsToFix, medianCol);
        System.out.println(stepsToWin);
    }


    // The function counts the number of moves needed to distribute the remaining ships
    private static int calculateStepsToWin(HashMap<Integer, Pair> filledCells, ArrayList<Pair> shipsToFix, int medianCol) {
        // Sorting by columns
        shipsToFix.sort(Comparator.comparing(o -> o.x));
        int minSteps = 0;
        for (Pair ship : shipsToFix) {
            // We put the ship in the first line that comes to hand and count the number of steps
            // necessary to reach the required position
            for (int i = 1; i < filledCells.size() + 1; ++i) {
                if (filledCells.get(i) == null) {
                    minSteps += (Math.abs(i - ship.x) + Math.abs(medianCol - ship.y));
                    filledCells.replace(i, ship);
                    break;
                }
            }
        }

        return minSteps;
    }


    // The class describes a pair of numbers
    private static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}