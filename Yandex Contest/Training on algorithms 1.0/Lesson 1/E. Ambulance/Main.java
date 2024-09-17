import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int k1 = -1, m = -1, k2 = -1, p2 = -1, n2 = -1;

        // Reading the data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                k1 = Integer.parseInt(split[0]);
                m = Integer.parseInt(split[1]);
                k2 = Integer.parseInt(split[2]);
                p2 = Integer.parseInt(split[3]);
                n2 = Integer.parseInt(split[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // We are going through all possible options
        int p1 = -1, n1 = -1;
        for (int maxFlat = 1; maxFlat < 10e6 + 1; ++maxFlat) {
            if (!isCorrectMaxFlat(k2, p2, m, n2, maxFlat)) {
                continue;
            }

            // We get the correct data for this stage
            int entrance = getEntrance(k1, m, maxFlat);
            int floor = getFloor(k1, m, maxFlat);

            // If this is the first change
            if (p1 == -1) {
                p1 = entrance;
                n1 = floor;
            }
            // If it is impossible to determine the entrance
            else if (p1 != entrance && p1 != 0) {
                p1 = 0;
            }
            // If it is impossible to determine the floor
            else if (n1 != floor && n1 != 0) {
                n1 = 0;
            }
        }

        System.out.print(p1 + " " + n1);
    }

    // Check whether the given number of apartments per floor is correct
    private static boolean isCorrectMaxFlat(int k, int p, int m, int n, int maxFlat) {
        return getEntrance(k, m, maxFlat) == p && getFloor(k, m, maxFlat) == n;
    }

    // Getting an entrance
    private static int getEntrance(int k, int m, int maxFlat) {
        return (int) Math.ceil((double) k / (maxFlat * m));
    }

    // Getting a floor
    private static int getFloor(int k, int m, int maxFlat) {
        int p = getEntrance(k, m, maxFlat);
        return (int) Math.ceil((double) k / maxFlat - ((p - 1) * m));
    }
}