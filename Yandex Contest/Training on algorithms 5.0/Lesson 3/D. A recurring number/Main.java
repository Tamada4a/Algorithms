import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // The corresponding value is stored in these variables
        int n = Integer.MAX_VALUE, k = Integer.MAX_VALUE;

        // This HashMap will store pairs <number : index of the last, at the moment, occurrence of
        // the number>
        HashMap<Integer, Integer> integersMap = new HashMap<>();

        // The answer to the question of the task is stored in the line
        String result = "NO";

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayOfInts = line.split(" ");
                if (n == Integer.MAX_VALUE) {
                    n = Integer.parseInt(arrayOfInts[0]);
                    k = Integer.parseInt(arrayOfInts[1]);
                } else {
                    // Filling the HashMap
                    for (int i = 0; i < n; ++i) {
                        int numInt = Integer.parseInt(arrayOfInts[i]);
                        // If such a number has been encountered, we look at the difference between the
                        // current index and the index of the last occurrence. If it fits the condition,
                        // we exit the cycle
                        if (integersMap.containsKey(numInt) && (i - integersMap.get(numInt) <= k)) {
                            result = "YES";
                            break;
                        }
                        // Otherwise, if there was no such number, we put it in the HashMap along with
                        // the index or update the index
                        else
                            integersMap.put(numInt, i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(result);
    }
}