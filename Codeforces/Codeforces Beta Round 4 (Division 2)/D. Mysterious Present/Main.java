import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // These variables contain the corresponding values
        int n, w, h;

        // This array will store triples: width, height, index
        ArrayList<Triple> listOfLetters = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            w = Integer.parseInt(split[1]);
            h = Integer.parseInt(split[2]);

            listOfLetters.add(new Triple(w, h, 0));

            for (int i = 0; i < n; ++i) {
                split = reader.readLine().split(" ");

                Triple triple = new Triple(Integer.parseInt(split[0]), Integer.parseInt(split[1]), i + 1);

                if (w >= triple.w || h >= triple.h)
                    continue;

                listOfLetters.add(triple);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sorting the array in reverse order
        listOfLetters.sort(Collections.reverseOrder());

        // This array will store the lengths of the maximum chains for each envelope
        int[] dpArray = new int[listOfLetters.size()];

        // This array will store the envelope indexes, at which the maximum chain length for
        // the i-th envelope is reached
        int[] idxGivesMaxRoute = new int[listOfLetters.size()];
        for (int i = 1; i < listOfLetters.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (listOfLetters.get(j).h > listOfLetters.get(i).h && listOfLetters.get(j).w > listOfLetters.get(i).w) {
                    dpArray[i] = Math.max(dpArray[i], dpArray[j] + 1);
                    if (dpArray[i] == dpArray[j] + 1)
                        idxGivesMaxRoute[i] = listOfLetters.get(j).idx;
                }
            }
        }

        // We output the result
        System.out.println(dpArray[listOfLetters.size() - 1]);
        if (dpArray[listOfLetters.size() - 1] != 0) {
            int cnt = 0;
            for (int i = listOfLetters.size() - 1; i > -1 && cnt != dpArray[listOfLetters.size() - 1]; --i) {
                if (dpArray[i] == dpArray[listOfLetters.size() - 1] - cnt) {
                    System.out.print(idxGivesMaxRoute[i] + " ");
                    cnt++;
                }
            }
        }
    }


    // This class is necessary to store three numbers in one object
    private record Triple(int w, int h, int idx) implements Comparable<Triple> {
        // Overriding the string representation of an object
        @Override
        public String toString() {
            return "Triple{w=%d, h=%d, idx=%d}".formatted(this.w, this.h, this.idx);
        }

        // Overriding the comparison method
        @Override
        public int compareTo(Triple triple) {
            if (this.w == triple.w)
                return Integer.compare(this.h, triple.h);
            return Integer.compare(this.w, triple.w);
        }
    }
}