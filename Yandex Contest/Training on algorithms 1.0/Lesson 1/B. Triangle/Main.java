import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // This variable will store the lengths of the sides of the triangle, ordered in ascending order of length
        TreeMap<Integer, Integer> triangleSides = new TreeMap<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int length = Integer.parseInt(line);
                    if (!triangleSides.containsKey(length)) {
                        triangleSides.put(length, 0);
                    }
                    triangleSides.put(length, triangleSides.get(length) + 1);
                } catch (NumberFormatException ignored){}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Index of the current element
        int i = 0;
        // The sum of the sides length
        int sum = 0;
        // Maximum length value
        int max = -1;

        // We calculate the sum of the lengths of the smaller sides of the triangle
        for (int key : triangleSides.keySet()) {
            // If you have reached the longest length
            if (i == (triangleSides.size() - 1)) {
                // Here we subtract one, since there can be two sides with the longest side length
                sum += key * (triangleSides.get(key) - 1);
                max = key;
            }
            // Otherwise, we add the length of the side multiplied by the number of such sides
            else {
                sum += key * triangleSides.get(key);
            }
            i++;
        }

        // You can build a triangle if the sum of the lengths of the smaller sides is greater than the length of the larger side
        if (sum > max) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}