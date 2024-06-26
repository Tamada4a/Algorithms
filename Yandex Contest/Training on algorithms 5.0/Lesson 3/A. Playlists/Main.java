import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // The corresponding value will be stored in this variable
        int n = Integer.MAX_VALUE;

        // In this variable we will store pairs <song : number of repetitions>. Because of TreeMap,
        // songs (keys) will be stored in sorted order
        TreeMap<String, Integer> commonSongsMap = new TreeMap<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (n == Integer.MAX_VALUE) {
                    n = Integer.parseInt(line);
                } else {
                    String[] array = reader.readLine().split(" ");
                    for (String song : array) {
                        // If there is no song in the HashMap, add it
                        if (!commonSongsMap.containsKey(song))
                            commonSongsMap.put(song, 0);

                        // Updating the number of repetitions of the song
                        commonSongsMap.put(song, commonSongsMap.get(song) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Common songs will be stored in this variable
        StringBuilder result = new StringBuilder();
        // This variable will store the number of common songs
        int commonSongsCnt = 0;

        for (String song : commonSongsMap.keySet()) {
            if (commonSongsMap.get(song) == n) {
                result.append("%s ".formatted(song));
                commonSongsCnt++;
            }
        }
        System.out.println(commonSongsCnt);
        System.out.print(result.toString().strip());
    }
}