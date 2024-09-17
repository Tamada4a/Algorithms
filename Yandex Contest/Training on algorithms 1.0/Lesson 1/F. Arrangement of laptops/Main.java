import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int w1 = -1, h1 = -1, w2 = -1, h2 = -1;

        // Reading the data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                w1 = Integer.parseInt(split[0]);
                h1 = Integer.parseInt(split[1]);
                w2 = Integer.parseInt(split[2]);
                h2 = Integer.parseInt(split[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // We iterate over all possible values of the areas
        int square1 = calcSquare(h1, h2, w1, w2);
        int square2 = calcSquare(h1, w2, w1, h2);
        int square3 = calcSquare(w1, h2, h1, w2);
        int square4 = calcSquare(w1, w2, h1, h2);

        // Choosing the minimum
        int min = Stream.of(square1, square2, square3, square4).mapToInt(num -> num).min().getAsInt();
        if (min == square1) {
            System.out.print((h1 + h2) + " " + Math.max(w1, w2));
        } else if (min == square2) {
            System.out.print((h1 + w2) + " " + Math.max(w1, h2));
        } else if (min == square3) {
            System.out.print((w1 + h2) + " " + Math.max(h1, w2));
        } else if (min == square4) {
            System.out.print((w1 + w2) + " " + Math.max(h1, h2));
        }
    }

    // Function for calculating the area
    private static int calcSquare(int a, int b, int c, int d) {
        return (a + b) * Math.max(c, d);
    }
}