import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int n = Integer.MAX_VALUE;

        // The coordinates from the file will be stored in this list
        ArrayList<Pair> coordList = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (n == Integer.MAX_VALUE)
                    n = Integer.parseInt(line);
                else if (!line.isEmpty()){
                    coordList.add(new Pair(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Creating a set in which all points will be stored - for faster access
        HashSet<Pair> coordSet = new HashSet<>(coordList);

        // Initialize the starting coordinates
        int x0 = coordList.get(0).x, y0 = coordList.get(0).y;

        // Initialize the list with three coordinates. In case we have only one point at the entrance
        List<Pair> ansList = List.of(
                new Pair(x0 + 1, y0 + 1),
                new Pair(x0 + 1, y0),
                new Pair(x0, y0 + 1));

        // We run through all the points and count the distances
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j)
                    continue;
                int x1 = coordList.get(i).x, y1 = coordList.get(i).y;
                int x2 = coordList.get(j).x, y2 = coordList.get(j).y;
                int dx = x2 - x1;
                int dy = y2 - y1;
                int x3 = x1 + dy;
                int y3 = y1 - dx;
                int x4 = x3 + dx;
                int y4 = y3 + dy;

                // If we already have all the points of the square, we do nothing
                if (coordSet.contains(new Pair(x3, y3)) && coordSet.contains(new Pair(x4, y4)))
                    ansList = new ArrayList<>();

                // If we have two/three points in the answer and there is a point with coordinates (x3, y3) in the set,
                // we change the answer to the best one - one point instead of two/three
                if (ansList.size() > 1 && coordSet.contains(new Pair(x3, y3)))
                    ansList = List.of(new Pair(x4, y4));

                // If we have two/three points in the answer and there is a point with coordinates (x4, y4) in the set,
                // we change the answer to the best one - one point instead of two/three
                if (ansList.size() > 1 && coordSet.contains(new Pair(x4, y4)))
                    ansList = List.of(new Pair(x3, y3));

                // If our array is initialized with starting values from (x0, y0), we put the best option
                if (ansList.size() > 2)
                    ansList = List.of(new Pair(x3, y3), new Pair(x4, y4));
            }
        }

        // Forming a output
        StringBuilder resultString = new StringBuilder();
        resultString.append(String.format("%d\n", ansList.size()));
        for (Pair pair : ansList) {
            resultString.append(String.format("%s\n", pair));
        }
        System.out.print(resultString.toString().strip());
    }


    // Defining the class of the pair
    private static class Pair {
        public int x;
        public int y;

        // Constructor by coordinates
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Constructor by line
        public Pair(String line) {
            String[] split = line.split(" ");
            this.x = Integer.parseInt(split[0]);
            this.y = Integer.parseInt(split[1]);
        }

        // Overriding the equality of Pair objects
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Pair p)) {
                return false;
            }
            return x == p.x && y == p.y;
        }

        // Overriding the hashCode
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        // Overriding toString
        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}