import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // The corresponding value will be stored in this variable
        int n = Integer.MAX_VALUE, k = Integer.MAX_VALUE;

        TreeMap<Long, Integer> difMap = new TreeMap<>(Collections.reverseOrder());

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            k = Integer.parseInt(split[1]);

            split = reader.readLine().split(" ");

            // For each digit of the number, we calculate the maximum difference taking into account
            // the order and add it to the TreeMap
            for (String strNum : split) {
                int num = Integer.parseInt(strNum);

                int weight = 1;
                // Work with the last digit of the number
                while (num > 0) {
                    int digit = num % 10;
                    long gain = (long) (9 - digit) * weight;

                    if (!difMap.containsKey(gain))
                        difMap.put(gain, 0);
                    difMap.put(gain, difMap.get(gain) + 1);

                    weight *= 10;
                    num /= 10;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long result = 0;

        // Sum the first k maximum differences
        for (long numKey : difMap.keySet()) {
            result += numKey * Math.min(k, difMap.get(numKey));
            k -= difMap.get(numKey);
            if (k <= 0)
                break;
        }
        System.out.print(result);
    }
}