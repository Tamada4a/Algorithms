import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // This TreeMap stores pairs <number : a set of lists in which this number occurred>.
        // We use TreeMap because it is necessary to output the numbers in ascending order, and TreeMap
        // ensures the ordering of the keys
        TreeMap<Integer, HashSet<Integer>> integersMap = new TreeMap<>();

        // This variable will store the index of the current list
        int counter = 0;

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            while ((reader.readLine()) != null) {
                String[] arrayOfInts = reader.readLine().split(" ");
                // Filling the TreeMap
                for (String num : arrayOfInts) {
                    int numInt = Integer.parseInt(num);
                    // If there was no number, add the set from the number of the current list
                    if (!integersMap.containsKey(numInt))
                        integersMap.put(numInt, new HashSet<>(counter));
                    // Adding the index of the current list to the set
                    integersMap.get(numInt).add(counter);
                }
                counter += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // We output numbers that occur in at least two lists
        StringBuilder result = new StringBuilder();
        for (int num : integersMap.keySet()) {
            if (integersMap.get(num).size() > 1)
                result.append(String.format("%d ", num));
        }
        System.out.print(result.toString().strip());
    }
}