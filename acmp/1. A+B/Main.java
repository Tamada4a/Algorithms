import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line to list of 2 numbers
                List<Integer> split = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                // Print result
                System.out.print(split.get(0) + split.get(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}