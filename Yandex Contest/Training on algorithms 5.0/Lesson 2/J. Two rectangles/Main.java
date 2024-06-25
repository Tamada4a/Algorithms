import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int m = Integer.MAX_VALUE, n = Integer.MAX_VALUE;

        // The array contains the input matrix
        ArrayList<StringBuilder> matrix = new ArrayList<>();

        // Coordinates of the corners of two rectangles
        int x11 = -1, y11 = -1, x12 = -1, y12 = -1, x13 = -1, y13 = -1, x14 = -1, y14 = -1;
        int x21 = -1, y21 = -1, y23 = -1;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                if (m == Integer.MAX_VALUE) {
                    m = scanner.nextInt();
                    n = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    // We use barriers so as not to worry about going beyond the boundaries of the array
                    if (matrix.size() == 0)
                        matrix.add(new StringBuilder("x".repeat(n + 2)));

                    matrix.add(new StringBuilder(String.format("x%sx", scanner.nextLine())));

                    if (matrix.size() == m + 1)
                        matrix.add(new StringBuilder("x".repeat(n + 2)));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // The size of the first shape after filling
        int aBlockSize = 0;

        // The size of the second shape after filling
        int bBlockSize = 0;

        // Setting the boundaries of the rectangles
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (matrix.get(i).charAt(j) == '#') {
                    // If the upper-left corner of the first rectangle is empty, we change the
                    // coordinates of the upper-left corner
                    if (x11 == -1) {
                        x11 = j;
                        y11 = i;
                        matrix.get(i).setCharAt(j, 'a');
                        aBlockSize += 1;
                    // If we have the same string as the upper-right corner of the first rectangle,
                    // and we met the letter 'a' before that, we change the coordinates of the
                    // upper-right corner
                    } else if (i == y11 && matrix.get(i).charAt(j - 1) == 'a') {
                        y12 = i;
                        x12 = j;
                        matrix.get(i).setCharAt(j, 'a');
                        aBlockSize += 1;
                    // If we are in the same column as the upper-left corner of the first rectangle,
                    // and the letter 'a' is above us and at the moment we have a rectangle formed
                    // or just the lower-left corner is empty, we change the coordinates of the
                    // lower-left corner
                    } else if (j == x11 && matrix.get(i - 1).charAt(j) == 'a' &&
                            (x14 == x12 || x13 == -1)) {
                        x13 = j;
                        y13 = i;
                        matrix.get(i).setCharAt(j, 'a');
                        aBlockSize += 1;
                    // If we are in the same row as the lower-left corner of the first rectangle, while
                    // we have the letter 'a' on the left and above us, we change the coordinates of
                    // the lower-right corner
                    } else if (i == y13 && matrix.get(i).charAt(j - 1) == 'a' &&
                            matrix.get(i - 1).charAt(j) == 'a') {
                        y14 = i;
                        x14 = j;
                        matrix.get(i).setCharAt(j, 'a');
                        aBlockSize += 1;
                    // If the upper left corner of the second rectangle is not filled in
                    } else if (x21 == -1) {
                        x21 = j;
                        y21 = i;
                        matrix.get(i).setCharAt(j, 'b');
                        bBlockSize += 1;
                    // If we are in the same row as the upper-left corner of the second rectangle,
                    // and the letter 'b' or 'a' is to our left, and the first rectangle consists of
                    // at least 2 squares, we change the coordinates of the upper-right corner
                    } else if (i == y21 && (matrix.get(i).charAt(j - 1) == 'b' ||
                            matrix.get(i).charAt(j - 1) == 'a') && aBlockSize > 1) {
                        matrix.get(i).setCharAt(j, 'b');
                        if (matrix.get(i).charAt(j - 1) == 'a') {
                            matrix.get(i).setCharAt(j - 1, 'b');
                        }
                        bBlockSize += 1;
                    // If we are in the same column as the upper-left corner of the second rectangle
                    // and the letter 'b' is above us, we change the coordinates of the lower-left
                    // corner
                    } else if (j == x21 && matrix.get(i - 1).charAt(j) == 'b') {
                        y23 = i;
                        matrix.get(i).setCharAt(j, 'b');
                        bBlockSize += 1;
                    // If we are in the same row as the lower-left corner of the second rectangle,
                    // and the letter 'b' is to our left and above us, we change the coordinates of
                    // the lower-right corner
                    } else if (i == y23 && matrix.get(i).charAt(j - 1) == 'b' &&
                            matrix.get(i - 1).charAt(j) == 'b') {
                        matrix.get(i).setCharAt(j, 'b');
                        bBlockSize += 1;
                    }
                }
            }
        }

        // We correct the shapes of both rectangles if we do not have elements in the second block or
        // the first rectangle is not a rectangle
        if (bBlockSize == 0 && aBlockSize > 1 ||
                isARectangle(aBlockSize, x11, y11, x12, y12, x13, y13, x14, y14)) {
            // If we have the first rectangle in the form of a ladder with one step from the bottom
            if (x13 != -1) {
                if (x14 == -1)
                    x14 = x13;

                for (int j = x13; j < x14 + 1; ++j) {
                    matrix.get(y13).setCharAt(j, 'b');
                }

                y13 -= 1;
            // If the first rectangle is a rectangle and you just need to split it in half
            } else {
                x13 = x11;
                y13 = y11;

                if (x14 == -1) {
                    y14 = y12;
                }
                for (int i = y11; i < y14 + 1; ++i) {
                    for (int j = x11 + (x12 - x11) / 2 + 1; j < x12 + 1; ++j) {
                        matrix.get(i).setCharAt(j, 'b');
                    }
                }

                x12 = (x12 - x11) / 2 + 1;
            }
            bBlockSize += 1;
            x14 = x12;
            y14 = y13;
        }

        // If we still have lattices in the matrix, or there are no elements of the second rectangle,
        // the first rectangle is not a rectangle
        if (isContainsGrid(matrix) || bBlockSize == 0 && aBlockSize < 2 || bBlockSize > 0 &&
                isARectangle(aBlockSize, x11, y11, x12, y12, x13, y13, x14, y14)) {
            System.out.print("NO");
        } else {
            System.out.println("YES");
            for (int i = 1; i < m + 1; ++i) {
                for (int j = 1; j < n + 1; ++j) {
                    System.out.print(matrix.get(i).charAt(j));
                }
                if (i != m)
                    System.out.println();
            }
        }
    }


    // The function allows you to determine whether the matrix contains a #
    private static boolean isContainsGrid(ArrayList<StringBuilder> matrix) {
        for (int i = 1; i < matrix.size() - 1; ++i) {
            if (matrix.get(i).indexOf("#") != -1)
                return true;
        }
        return false;
    }


    // The function allows you to determine whether the first rectangle is a rectangle
    private static boolean isARectangle(int aBlockSize, int x11, int y11, int x12, int y12, int x13, int y13, int x14, int y14) {
        if (aBlockSize == 1)
            return false;

        if (x12 == -1 && x14 == -1 && x11 == x13)
            return false;

        if (x13 == -1 && x14 == -1 && y11 == y12)
            return false;

        return x11 != x13 || x12 != x14 || y11 != y12 || y13 != y14;
    }
}