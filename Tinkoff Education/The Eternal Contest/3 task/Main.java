import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // The corresponding value will be stored in this variable
        int n = Integer.MAX_VALUE, t = Integer.MAX_VALUE, empIdx = Integer.MAX_VALUE;

        ArrayList<Integer> empFloors = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            t = Integer.parseInt(split[1]);

            empFloors = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            empIdx = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find the time from the first floor to the one we need
        int left = empFloors.get(empIdx - 1) - empFloors.get(0);

        // Find the time from the top floor to the one we need
        int right = empFloors.get(n - 1) - empFloors.get(empIdx - 1);

        // Find the time from the top floor to the bottom. This is the time in which all floors will be
        // completed if the required employee is on site at time t
        int maxDif = empFloors.get(n - 1) - empFloors.get(0);

        // If the employee does not leave
        if (left <= t || right <= t)
            System.out.print(maxDif);
        // Otherwise, we go up to the floor of the right employee and from this floor we bypass all
        // others floors
        else
            System.out.print(Math.min(left, right) + maxDif);
    }
}