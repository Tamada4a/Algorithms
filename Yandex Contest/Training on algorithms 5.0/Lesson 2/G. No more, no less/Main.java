import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in this variable
        int t = Integer.MAX_VALUE;

        // This variable will contain the results
        StringBuilder result = new StringBuilder();

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (t == Integer.MAX_VALUE)
                    t = scanner.nextInt();
                else {
                    // Run through all the sets
                    for (int ti = 0; ti < t; ++ti) {
                        int n = scanner.nextInt();

                        // Reading data
                        ArrayList<Integer> numbers = new ArrayList<>();
                        for (int ni = 0; ni < n; ++ni)
                            numbers.add(scanner.nextInt());

                        // Intermediate data will be added here
                        StringBuilder setResult = new StringBuilder();
                        int min = 1;
                        int counter = 0;
                        int lastElem = -1;
                        for (int ni = 0; ni < n;) {
                            int curInt = numbers.get(ni);
                            if (counter == 0)
                                min = 1;
                            else if (counter == 1)
                                min = lastElem;
                            else
                                min = Math.min(min, lastElem);

                            // If our current minimum still satisfies the condition and the current
                            // element can be added to a subset, then increase the counters and move
                            // on to the next element
                            if (min >= counter + 1 && curInt >= counter + 1) {
                                counter += 1;
                                ni += 1;
                                lastElem = curInt;
                            }
                            // Otherwise, add the generated subset to our resulting string
                            else {
                                setResult.append(String.format("%d ", counter));
                                counter = 0;
                            }
                        }
                        // Adding the size of the last subset
                        setResult.append(String.format("%d", counter));

                        // Adding the intermediate result to the final one
                        result.append(String.format("%d\n%s\n",
                                setResult.toString().split(" ").length, setResult));
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print(result.toString().strip());
    }
}