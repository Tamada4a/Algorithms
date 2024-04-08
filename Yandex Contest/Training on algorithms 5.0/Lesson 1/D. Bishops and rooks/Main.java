import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<char[]> chessBoard = new ArrayList<>();

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                chessBoard.add(scanner.nextLine().toCharArray());

                if (chessBoard.size() == 8)
                    break;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int result = 64;
        // We walk along the board. If we find a figure, we start moving away from it in the appropriate directions. If
        // we meet a "+" or another figure, we stop the cycle
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (chessBoard.get(i)[j] == 'R') {
                    // Running along the line to the left
                    for (int k = j; k > -1; --k) {
                        if (chessBoard.get(i)[k] == 'R' && k != j || chessBoard.get(i)[k] == 'B')
                            break;

                        if (chessBoard.get(i)[k] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(i)[k] != 'R' && chessBoard.get(i)[k] != 'B')
                            chessBoard.get(i)[k] = '+';
                    }

                    // Running along the line to the right
                    for (int k = j + 1; k < 8; ++k) {
                        if (chessBoard.get(i)[k] == 'R' || chessBoard.get(i)[k] == 'B')
                            break;

                        if (chessBoard.get(i)[k] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(i)[k] != 'R' && chessBoard.get(i)[k] != 'B')
                            chessBoard.get(i)[k] = '+';
                    }

                    // Running up the column
                    for (int k = i - 1; k > -1; --k) {
                        if (chessBoard.get(k)[j] == 'R' || chessBoard.get(k)[j] == 'B')
                            break;

                        if (chessBoard.get(k)[j] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(k)[j] != 'R' && chessBoard.get(k)[j] != 'B')
                            chessBoard.get(k)[j] = '+';
                    }

                    // Running down the column
                    for (int k = i + 1; k < 8; ++k) {
                        if (chessBoard.get(k)[j] == 'R' || chessBoard.get(k)[j] == 'B')
                            break;

                        if (chessBoard.get(k)[j] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(k)[j] != 'R' && chessBoard.get(k)[j] != 'B')
                            chessBoard.get(k)[j] = '+';
                    }
                } else if (chessBoard.get(i)[j] == 'B') {
                    // Running up to the right
                    for (int k = i, c = j; k > -1 && c < 8; --k, ++c) {
                        if (chessBoard.get(k)[c] == 'R' || chessBoard.get(k)[c] == 'B' && k != i && c != j)
                            break;

                        if (chessBoard.get(k)[c] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(k)[c] != 'R' && chessBoard.get(k)[c] != 'B')
                            chessBoard.get(k)[c] = '+';
                    }

                    // Running down to the right
                    for (int k = i + 1, c = j + 1; k < 8 && c < 8; ++k, ++c) {
                        if (chessBoard.get(k)[c] == 'R' || chessBoard.get(k)[c] == 'B' && k != i && c != j)
                            break;

                        if (chessBoard.get(k)[c] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(k)[c] != 'R' && chessBoard.get(k)[c] != 'B')
                            chessBoard.get(k)[c] = '+';
                    }

                    // Running up to the left
                    for (int k = i - 1, c = j - 1; k > -1 && c > -1; --k, --c) {
                        if (chessBoard.get(k)[c] == 'R' || chessBoard.get(k)[c] == 'B' && k != i && c != j)
                            break;

                        if (chessBoard.get(k)[c] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(k)[c] != 'R' && chessBoard.get(k)[c] != 'B')
                            chessBoard.get(k)[c] = '+';
                    }

                    // Running down to the left
                    for (int k = i + 1, c = j - 1; k < 8 && c > -1; ++k, --c) {
                        if (chessBoard.get(k)[c] == 'R' || chessBoard.get(k)[c] == 'B' && k != i && c != j)
                            break;

                        if (chessBoard.get(k)[c] == '+')
                            continue;
                        result -= 1;

                        if (chessBoard.get(k)[c] != 'R' && chessBoard.get(k)[c] != 'B')
                            chessBoard.get(k)[c] = '+';
                    }
                }
            }
        }
        System.out.println(result);
    }
}
