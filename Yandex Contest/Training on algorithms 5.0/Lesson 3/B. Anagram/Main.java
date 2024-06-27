import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // This HashMap will store pairs of <character : number of repetitions> for the first string
        HashMap<Character, Integer> firstWordMap = new HashMap<>();

        // This HashMap will store pairs of <character : number of repetitions> for the second string
        HashMap<Character, Integer> secondWordMap = new HashMap<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (firstWordMap.isEmpty())
                    fillMap(firstWordMap, line);
                else if (secondWordMap.isEmpty())
                    fillMap(secondWordMap, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(compareMaps(firstWordMap, secondWordMap));
    }


    // Function for filling HashMap with string characters
    private static void fillMap(HashMap<Character, Integer> map, String line) {
        char[] charArray = line.toCharArray();

        for (char sym : charArray) {
            if (!map.containsKey(sym))
                map.put(sym, 0);
            map.put(sym, map.get(sym) + 1);
        }
    }


    // The function compares the HashMaps with each other
    private static String compareMaps(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        // If the number of unique characters is not equal
        if (map1.size() != map2.size())
            return "NO";

        // Check all the keys of the first HashMap
        for (char sym : map1.keySet()) {
            // If there is no such character in the second string
            if (!map2.containsKey(sym))
                return "NO";

            // If the character occurs in both strings a different number of times
            if (!map2.get(sym).equals(map1.get(sym)))
                return "NO";
        }

        return "YES";
    }
}