import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int N = Integer.MAX_VALUE;

        // These arrays store indexes of elements with positive, neutral and negative differences
        ArrayList<Berry> posIdxs = new ArrayList<>(), negIdxs = new ArrayList<>(), neutralIdxs = new ArrayList<>();

        // Elements Counter
        int counter = 1;

        // Each of the three Berry objects stores special elements for each type of array

        // It is added to the end of the neutral array
        // The largest in terms of elevation
        Berry specialNeutral = new Berry(0, 0, -1);

        // It is added to the beginning of the negative array
        // The largest in terms of elevation
        Berry specialNeg = new Berry(0, 0, -1);

        // It is added to the beginning of the positive array
        // The largest in terms of elevation
        Berry specialPosFirst = new Berry(0, 0, -1);

        // It is added to the end of the positive array
        // The bigger one on the descent
        Berry specialPosLast = new Berry(0, 0, -1);

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (N == Integer.MAX_VALUE)
                    N = scanner.nextInt();
                else {
                    int up = scanner.nextInt();
                    int down = scanner.nextInt();
                    int dif = up - down;

                    if (dif > 0) {
                        // If we have a contender for the first element in a positive array
                        if (up > specialPosFirst.up || up == specialPosFirst.up && dif > specialPosFirst.dif) {
                            specialPosFirst.dif = dif;
                            specialPosFirst.up = up;
                            specialPosFirst.down = down;
                            specialPosFirst.idx = counter;
                        }
                        // If we have a contender for the last element in the positive array
                        if (down > specialPosLast.down) {
                            specialPosLast.dif = dif;
                            specialPosLast.up = up;
                            specialPosLast.down = down;
                            specialPosLast.idx = counter;
                        }
                        posIdxs.add(new Berry(up, down, counter));
                    } else if (dif == 0) {
                        // If we have a contender for the last element in the neutral array
                        if (up > specialNeutral.up) {
                            specialNeutral.up = up;
                            specialNeutral.down = down;
                            specialNeutral.dif = dif;
                            specialNeutral.idx = counter;
                        }
                        neutralIdxs.add(new Berry(up, down, counter));
                    } else {
                        // If we have a contender for the first element in the negative array
                        if (up > specialNeg.up) {
                            specialNeg.up = up;
                            specialNeg.down = down;
                            specialNeg.dif = dif;
                            specialNeg.idx = counter;
                        }
                        negIdxs.add(new Berry(up, down, counter));
                    }

                    counter += 1;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // We remove the corresponding elements and add them to the necessary places
        if (specialPosFirst.idx != -1 && !posIdxs.isEmpty()) {
            removeIdx(posIdxs, specialPosFirst.idx);
            posIdxs.add(0, specialPosFirst);
        }

        if (specialPosLast.idx != -1 && !posIdxs.isEmpty() && specialPosLast.idx != specialPosFirst.idx) {
            removeIdx(posIdxs, specialPosLast.idx);
            posIdxs.add(posIdxs.size(), specialPosLast);
        }

        if (specialNeutral.idx != -1 && !neutralIdxs.isEmpty()) {
            removeIdx(neutralIdxs, specialNeutral.idx);
            neutralIdxs.add(neutralIdxs.size(), specialNeutral);
        }

        if (specialNeg.idx != -1 && !negIdxs.isEmpty()) {
            removeIdx(negIdxs, specialNeg.idx);
            negIdxs.add(0, specialNeg);
        }

        System.out.print(getAnswer(posIdxs, neutralIdxs, negIdxs));
    }


    // A function to remove an element from an array
    private static void removeIdx(ArrayList<Berry> idxs, int idxToRemove) {
        Iterator<Berry> i = idxs.iterator();
        while (i.hasNext()) {
            Berry elem = i.next();
            if (elem.idx == idxToRemove) {
                i.remove();
                break;
            }
        }
    }


    // The function for getting the final answer
    private static String getAnswer(ArrayList<Berry> pos, ArrayList<Berry> neutral, ArrayList<Berry> neg) {
        String answerPos = convertArrayToString(pos);
        String answerNeutral = convertArrayToString(neutral);
        String answerNeg = convertArrayToString(neg);

        // Counting the highest height
        long result = 0;
        for (Berry po : pos) {
            result += po.dif;
        }

        for (Berry berry : neutral) {
            result += berry.dif;
        }

        long maxPos = 0;
        long maxNeutral = 0;
        long maxNeg = 0;

        // Calculating the maximum height for different situations
        if (!neg.isEmpty())
            maxNeg = neg.get(0).up + result;

        if (!neutral.isEmpty()) {
            Berry neutralLastElem = neutral.get(neutral.size() - 1);
            maxNeutral = result + neutralLastElem.down;
        }

        if (!pos.isEmpty() && neutral.isEmpty()) {
            Berry posLastElem = pos.get(pos.size() - 1);
            maxPos = result + posLastElem.down;
        }

        // Choose the highest height of the three
        result = Math.max(maxNeg, Math.max(maxPos, maxNeutral));

        return String.format("%s\n%s%s%s", result, answerPos, answerNeutral, answerNeg).strip();
    }


    // The function translates a set of objects into a row of indexes
    private static String convertArrayToString(ArrayList<Berry> idxs) {
        StringBuilder answer = new StringBuilder();

        if (!idxs.isEmpty()) {
            for (Berry idx : idxs) {
                answer.append(String.format("%s ", idx.idx));
            }
        }

        return answer.toString();
    }


    // A class that stores information about a berry
    private static class Berry {
        public int up;

        public int down;

        public int idx;

        public int dif;


        public Berry(int up, int down, int idx) {
            this.up = up;
            this.down = down;
            this.idx = idx;
            this.dif = up - down;
        }
    }
}