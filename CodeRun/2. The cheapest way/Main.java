import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // These variables will contain the corresponding values
        int n = Integer.MAX_VALUE, m = Integer.MAX_VALUE;

        // This matrix will store the original matrix
        int[][] inputMatrix = {};

        // This matrix will store the weights of each vertex after executing Dijkstra's algorithm
        int[][] dijkstraMatrix = {};

        // This HashMap will contain unvisited vertices.
        // The key will be the vertex number, and the value will be the cost of the path to it
        HashMap<Integer, Integer> unvisitedNodes = new HashMap<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);

            // We add 2 dimensions to each dimension, since we will use additional boundaries so as
            // not to process going beyond the boundaries of the array once again
            inputMatrix = new int[n + 2][m + 2];
            dijkstraMatrix = new int[n + 2][m + 2];

            // Filling in the matrices
            for (int i = 1; i < n + 1; ++i) {
                split = reader.readLine().split(" ");
                for (int j = 1; j < m + 1; ++j) {
                    // We add a starting point to the Dijkstra matrix
                    if (i == 1 && j == 1)
                        dijkstraMatrix[i][j] = Integer.parseInt(split[j - 1]);
                    // Initialize the remaining points with infinity
                    else
                        dijkstraMatrix[i][j] = Integer.MAX_VALUE;

                    // Adding a vertex as an unvisited one
                    unvisitedNodes.put(i * (m + 2) + j, dijkstraMatrix[i][j]);

                    // Filling in the matrix
                    inputMatrix[i][j] = Integer.parseInt(split[j - 1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This set will contain the visited vertices
        HashSet<Integer> visitedNodes = new HashSet<>();

        // Iterate until we visit all the vertices
        while (visitedNodes.size() != n * m) {
            // We get an unvisited vertex with a minimum cost from the HashMap
            int minIdx = Collections.min(unvisitedNodes.entrySet(), Map.Entry.comparingByValue()).getKey();

            // By the vertex number, we determine the index in the matrix
            int curI = minIdx / (m + 2);
            int curJ = minIdx % (m + 2);

            // We update the cost of neighboring vertices at least the current value in the Dijkstra
            // matrix and the sum of the current cost and the cost of moving to the neighboring vertex
            dijkstraMatrix[curI + 1][curJ] = Math.min(dijkstraMatrix[curI + 1][curJ], inputMatrix[curI + 1][curJ] + dijkstraMatrix[curI][curJ]);
            dijkstraMatrix[curI][curJ + 1] = Math.min(dijkstraMatrix[curI][curJ + 1], inputMatrix[curI][curJ + 1] + dijkstraMatrix[curI][curJ]);

            // Updating the cost of unvisited neighboring vertices
            if (unvisitedNodes.containsKey((curI + 1) * (m + 2) + curJ))
                unvisitedNodes.put((curI + 1) * (m + 2) + curJ, dijkstraMatrix[curI + 1][curJ]);

            if (unvisitedNodes.containsKey(curI * (m + 2) + curJ + 1))
                unvisitedNodes.put(curI * (m + 2) + curJ + 1, dijkstraMatrix[curI][curJ + 1]);

            // Marking the current vertex as visited
            visitedNodes.add(minIdx);

            // Removing the current vertex from the unvisited ones
            unvisitedNodes.remove(minIdx);
        }

        System.out.print(dijkstraMatrix[n][m]);
    }
}