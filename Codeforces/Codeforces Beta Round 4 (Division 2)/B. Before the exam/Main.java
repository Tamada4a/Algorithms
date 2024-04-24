import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // These variables will contain the corresponding values
        int d = Integer.MAX_VALUE, sumTime = Integer.MAX_VALUE;

        // This lists will contain minTime and maxTime respectively
        ArrayList<Integer> minTimeList = new ArrayList<>();
        ArrayList<Integer> maxTileList = new ArrayList<>();

        // Sums of minTime and maxTime
        int minTimeSum = 0;
        int maxTimeSum = 0;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            d = Integer.parseInt(split[0]);
            sumTime = Integer.parseInt(split[1]);

            for (int i = 0; i < d; ++i) {
                split = reader.readLine().split(" ");

                minTimeList.add(Integer.parseInt(split[0]));
                maxTileList.add(Integer.parseInt(split[1]));

                minTimeSum += minTimeList.get(minTimeList.size() - 1);
                maxTimeSum += maxTileList.get(maxTileList.size() - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If we go beyond the minimum or maximum amount, we print NO
        if (sumTime > maxTimeSum || sumTime < minTimeSum) {
            System.out.print("NO");
        }
        // Else, we calculate how many hours we need to spend on the i-th day
        else {
            int dif = sumTime - minTimeSum;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < d; ++i) {
                // If there is a difference between the sum of minTime and sumTime, then we add
                // the minTime of the i-th day to the answer
                if (dif == 0)
                    result.append(String.format("%d ", minTimeList.get(i)));
                // Else we calculate min dif for i-th day and reduce the dif by a value equal to minDif
                // in order to correctly calculate the time spent on each day
                else {
                    int minDif = Math.min(dif, maxTileList.get(i) - minTimeList.get(i));
                    dif -= minDif;
                    result.append(String.format("%d ", minTimeList.get(i) + minDif));
                }
            }
            System.out.println("YES");
            System.out.print(result.toString().strip());
        }
    }
}