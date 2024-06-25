import java.util.Scanner;

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
class Player {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            // The maximum vertex will be stored in this variable
            int maxMountainH = Integer.MIN_VALUE;

            // This variable will store the index of the maximum vertex
            int maxMountainIdx = -1;

            // Looking for the maximum
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt();
                if (mountainH > maxMountainH) {
                    maxMountainH = mountainH;
                    maxMountainIdx = i;
                }
            }

            System.out.println(maxMountainIdx); // The index of the mountain to fire on.
        }
    }
}