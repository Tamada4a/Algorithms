import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // The corresponding value is stored in this variable
        int n = Integer.MAX_VALUE;

        // This TreeMap will store pairs <number : number of repetitions>.
        // We use TreeMap, because an ordered sequence of keys will be required when calculating the
        // answer
        TreeMap<Integer, Integer> integersMap = new TreeMap<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (n == Integer.MAX_VALUE)
                    n = Integer.parseInt(line);
                else {
                    String[] arrayOfInts = line.split(" ");
                    // Filling in the TreeMap. If there is no element, add a new one with a value of 0
                    for (String num : arrayOfInts) {
                        int numInt = Integer.parseInt(num);
                        if (!integersMap.containsKey(numInt))
                            integersMap.put(numInt, 0);
                        integersMap.put(numInt, integersMap.get(numInt) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // If we have one unique number, we do not delete anything, because the difference between them
        // is 0
        if (integersMap.size() == 1)
            System.out.print(0);
        else {
            // We make a list of the set of keys in order to iterate and compare them
            ArrayList<Integer> listOfNums = new ArrayList<>(integersMap.keySet());

            // Creating a variable that will store the maximum
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < listOfNums.size() - 1; ++i) {
                // We only work with a pair of numbers that differ by a maximum of 1
                if (Math.abs(listOfNums.get(i + 1) - listOfNums.get(i)) > 1)
                    continue;

                // We count their total number of repetitions. We need to remove the minimum number of
                // numbers, so we need to find the maximum number of numbers that differ by 1 from each other
                int sum = integersMap.get(listOfNums.get(i + 1)) + integersMap.get(listOfNums.get(i));
                if (sum > max)
                    max = sum;
            }

            // If we do not have numbers that differ by 1, then we set max = 1, that is, it will be
            // necessary to remove n - 1 numbers so that one number remains in the sequence, which
            // differs by 0 by itself
            if (max == Integer.MIN_VALUE)
                max = 1;

            System.out.print(n - max);
        }
    }
}