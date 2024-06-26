import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int width, height;

        // The key is the row number, in the set - the indexes of the columns located in this row
        HashMap<Integer, TreeSet<Integer>> powerNodesNeighborByRow = new HashMap<>();

        // The key is the number of the column, in the set - the indexes of the rows located in this
        // column
        HashMap<Integer, TreeSet<Integer>> powerNodesNeighborByCol = new HashMap<>();

        // This list will contain all the power nodes
        ArrayList<Pair> powerNodesSet = new ArrayList<>();

        // Reading data
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            width = Integer.parseInt(reader.readLine());
            height = Integer.parseInt(reader.readLine());
            for (int i = 0; i < height; ++i) {
                // If necessary, add a new line to the HashMap
                if (!powerNodesNeighborByRow.containsKey(i))
                    powerNodesNeighborByRow.put(i, new TreeSet<>());

                String line = reader.readLine();
                for (int j = 0; j < width; ++j) {
                    // If necessary, add a new column to the HashMap
                    if (!powerNodesNeighborByCol.containsKey(j))
                        powerNodesNeighborByCol.put(j, new TreeSet<>());

                    // Updating the data
                    if (line.charAt(j) == '0') {
                        powerNodesNeighborByCol.get(j).add(i);
                        powerNodesNeighborByRow.get(i).add(j);
                        powerNodesSet.add(new Pair(j, i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Pair powerNode : powerNodesSet) {
            System.out.printf("%d %d", powerNode.col, powerNode.row);
            printCoordinates(powerNodesNeighborByRow.get(powerNode.row), powerNode.col, powerNode.row, 0);
            printCoordinates(powerNodesNeighborByCol.get(powerNode.col), powerNode.row, powerNode.col, 1);
            System.out.println();
        }
    }


    // The function allows you to display the nearest coordinates of the power node
    private static void printCoordinates(TreeSet<Integer> set, int valToCheck, int fixVal, int type) {
        int closest = -1;
        // Since TreeSet is used, the coordinates are already ordered, and we need to find the first
        // largest element
        for (int setVal : set) {
            if (setVal > valToCheck) {
                closest = setVal;
                break;
            }
        }

        // If no larger element was found
        if (closest == -1)
            System.out.print(" -1 -1");
        // Otherwise, we output the coordinates of the neighbor
        else {
            // type == 0 - row
            // type == 1 - column
            if (type == 0)
                System.out.printf(" %d %d", closest, fixVal);
            else
                System.out.printf(" %d %d", fixVal, closest);
        }
    }


    // This class describes a pair of numbers
    private record Pair(int col, int row) {
    }
}