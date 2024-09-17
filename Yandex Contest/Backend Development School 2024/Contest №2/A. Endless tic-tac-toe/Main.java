import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;

        // In this variable, the coordinates of the points will be stored as keys, and the ordinal number of the player
        // who filled the cell will be stored as values
        HashMap<Pair, Integer> pointsSet = new HashMap<>();

        // Reading the data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (n == Integer.MAX_VALUE)
                    n = Integer.parseInt(line);
                else {
                    Pair pair = new Pair(line);
                    pointsSet.put(pair, pointsSet.size() % 2);
                    if (isGameEnded(pointsSet, pair)) {
                        if (pointsSet.size() == n) {
                            if ((pointsSet.size() - 1) % 2 == 0)
                                System.out.print("First");
                            else
                                System.out.print("Second");
                        } else {
                            System.out.print("Inattention");
                        }
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Draw");
    }


    // Let's find out if the game is over with the current number of moves
    private static boolean isGameEnded(HashMap<Pair, Integer> pointsSet, Pair curPoint) {
        int firstH = 0, firstV = 0, firstDL = 0, firstDR = 0;

        int[] offsetArr = {-4, -3, -2, -1, 0, 1, 2, 3, 4};

        int curX = curPoint.first;
        int curY = curPoint.second;

        for (int i = 0; i < 9; ++i) {
            Pair newH = new Pair(curX + offsetArr[i], curY);
            if (pointsSet.containsKey(newH) && pointsSet.get(newH).equals(pointsSet.get(curPoint)))
                firstH += 1;
            else
                firstH = 0;

            Pair newV = new Pair(curX, curY + offsetArr[i]);
            if (pointsSet.containsKey(newV) && pointsSet.get(newV).equals(pointsSet.get(curPoint)))
                firstV += 1;
            else
                firstV = 0;

            Pair newDL = new Pair(curX + offsetArr[i], curY - offsetArr[i]);
            if (pointsSet.containsKey(newDL) && pointsSet.get(newDL).equals(pointsSet.get(curPoint)))
                firstDL += 1;
            else
                firstDL = 0;

            Pair newDR = new Pair(curX + offsetArr[i], curY + offsetArr[i]);
            if (pointsSet.containsKey(newDR) && pointsSet.get(newDR).equals(pointsSet.get(curPoint)))
                firstDR += 1;
            else
                firstDR = 0;


            if (firstH == 5 || firstV == 5 || firstDL == 5 || firstDR == 5)
                break;
        }

        return firstH == 5 || firstV == 5 || firstDL == 5 || firstDR == 5;
    }

    // This class describes a pair of numbers
    private static class Pair {
        public int first;

        public int second;

        public Pair(String line) {
            String[] split = line.split(" ");
            this.first = Integer.parseInt(split[0]);
            this.second = Integer.parseInt(split[1]);
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) obj;
            return this.first == p.first && this.second == p.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.first, this.second);
        }

        @Override
        public String toString() {
            return String.format("Pair{first=%d, second=%d}", this.first, this.second);
        }
    }
}