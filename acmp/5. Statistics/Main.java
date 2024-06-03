import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // This variable will store the dates of even days
        ArrayList<String> evenAns = new ArrayList<>();

        // This variable will store the dates of odd days
        ArrayList<String> notEvenAns = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            // Skipping first line
            reader.readLine();

            String[] split = reader.readLine().split(" ");

            // Adding data to arrays
            for (String strNum : split) {
                if (Integer.parseInt(strNum) % 2 == 0)
                    evenAns.add(strNum);
                else
                    notEvenAns.add(strNum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(convertArrayToString(notEvenAns));
        System.out.println(convertArrayToString(evenAns));

        // If the number of fours is greater than or equal to the number of threes
        if (evenAns.size() >= notEvenAns.size())
            System.out.print("YES");
        else
            System.out.print("NO");
    }


    // This function converts an array to a string, removing unnecessary characters
    private static String convertArrayToString(ArrayList<String> array) {
        return array.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }
}