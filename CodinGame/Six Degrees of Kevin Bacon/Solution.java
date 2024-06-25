import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 6 Degrees of Kevin Bacon!
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String actorName = in.nextLine();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // This HashMap will store pairs of <actor name : its serial number>
        // HashMap will be used to get the vertex number in the graph
        HashMap<String, Integer> actorsMap = new HashMap<>();

        // In this matrix, a list of neighbors (partners in the film) will be stored for each
        // actor (vertex)
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();
        for (int i = 0; i < n * 10; ++i) {
            bfs.add(new ArrayList<>());
        }

        // Reading data
        for (int i = 0; i < n; ++i) {
            String movieCast = in.nextLine();
            String[] movieActors = movieCast.split(": ")[1].split(", ");

            for (int j = 0; j < movieActors.length; ++j) {
                // If necessary, add an actor (vertex) to the HashMap
                if (!actorsMap.containsKey(movieActors[j]))
                    actorsMap.put(movieActors[j], actorsMap.size());

                // For each subsequent actor (vertex), we add this actor (vertex) to the neighbors and
                // add a new neighbor to this actor (vertex)
                for (int c = j + 1; c < movieActors.length; ++c) {
                    if (!actorsMap.containsKey(movieActors[c]))
                        actorsMap.put(movieActors[c], actorsMap.size());

                    bfs.get(actorsMap.get(movieActors[c])).add(actorsMap.get(movieActors[j]));
                    bfs.get(actorsMap.get(movieActors[j])).add(actorsMap.get(movieActors[c]));
                }
            }
        }

        // We output the minimum number of films
        System.out.print(bfsMethod(actorsMap.get(actorName), actorsMap.size(), bfs, actorsMap.get("Kevin Bacon")));
    }


    // In this method, we implement BFS
    private static int bfsMethod(int startNode, int vertices, ArrayList<ArrayList<Integer>> bfs, int endNode) {
        // Creating a queue in which the unvisited vertices will be stored
        Queue<Integer> queue = new LinkedList<>();

        // Setting up an array of distances. We will store the minimum distances from the startNode
        // to the other vertices in it
        int[] dist = new int[vertices];
        // Filling the array with -1
        Arrays.fill(dist, -1);
        // For startNode, initialize 0, because you can't come to itself
        dist[startNode] = 0;

        // Adding startNode as the starting vertex
        queue.add(startNode);

        // Iterate over the queue
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue
            int currentNode = queue.poll();

            // Get all adjacent vertices of the dequeued vertex currentNode.
            // If an adjacent has not been visited (dist[neighbor] == -1), then mark it visited
            // (update dist) and enqueue it
            for (int neighbor : bfs.get(currentNode)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[currentNode] + 1;
                    queue.add(neighbor);

                    if (neighbor == endNode)
                        break;
                }
            }
        }


        // Return min dist from startNode to endNode
        return dist[endNode];
    }
}