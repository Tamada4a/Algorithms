import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // This array will contain all numbers
        ArrayList<Integer> list = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Sort list of numbers
        list.sort(Comparator.comparingInt(o -> o));

        // Printing middle element
        System.out.print(list.get(1));
    }
}