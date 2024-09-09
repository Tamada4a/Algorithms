import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int n = Integer.MAX_VALUE, k = Integer.MAX_VALUE;

        // Array for numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        // The row for the final result
        StringBuilder result = new StringBuilder();

        // Reading the data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (n == Integer.MAX_VALUE)
                    n = Integer.parseInt(line);
                else if (numbers.size() != n) {
                    String[] numbersSplit = line.split(" ");
                    for (String num : numbersSplit) {
                        numbers.add(Integer.parseInt(num));
                    }
                    numbers.sort(Comparator.comparing(o -> o));
                } else if (k == Integer.MAX_VALUE)
                    k = Integer.parseInt(line);
                else if (!line.isEmpty()) {
                    String[] rangeSplit = line.split(" ");
                    int l = Integer.parseInt(rangeSplit[0]);
                    int r = Integer.parseInt(rangeSplit[1]);

                    // We calculate the difference between two function calls, because first we will find numbers less
                    // than or equal to r, and then less than or equal to l - 1. The answer will be their difference
                    result.append(String.format("%s ", findPosition(numbers, r) - findPosition(numbers, l - 1)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(result.toString().strip());
    }


    // A function for searching for a shifted left border
    private static int findPosition(ArrayList<Integer> numbers, int key) {
        // Setting the boundaries of the search. l will be the answer, because all numbers with indexes from 0 to l
        // inclusive will be in the specified range (first the numbers up to r, then up to l - 1)
        int l = -1, r = numbers.size();
        while (l + 1 < r) {
            int middle = (r + l) / 2;
            if (numbers.get(middle) <= key)
                l = middle;
            else
                r = middle;
        }
        return l;
    }
}