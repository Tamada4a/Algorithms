import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // The corresponding value will be stored in this variable
        int n;

        // This variable will store the answer
        StringBuilder answer = new StringBuilder();

        // Pairs of the type <nickname : number of repetitions> will be stored in this variable
        Map<String, Integer> namesMap = new HashMap<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());

            for (int i = 1; i < n + 1; ++i) {
                String curName = reader.readLine();
                // If the name has already been encountered, add an ordinal number to it
                if (namesMap.containsKey(curName))
                    answer.append(String.format("%s%d\n", curName, namesMap.get(curName)));
                // Otherwise, output OK
                else {
                    answer.append("OK\n");
                    namesMap.put(curName, 0);
                }
                // Adding a name/hint to the database
                namesMap.put(curName, namesMap.get(curName) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(answer.toString().strip());
    }
}