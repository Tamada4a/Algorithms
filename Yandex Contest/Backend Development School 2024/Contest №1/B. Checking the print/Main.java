import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String targetWord = "";
        String log = "";

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            targetWord = reader.readLine().trim();
            log = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int pointer = 0;
        StringBuilder conStruct = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < log.length(); ++i) {
            if (log.charAt(i) == '<') {
                conStruct.append('<');
                for (int j = i + 1; j < log.length() && j < i + 8; ++j) {
                    conStruct.append(log.charAt(j));
                    if (log.charAt(j) != '>')
                        continue;

                    String conStructStr = conStruct.toString();
                    if (conStructStr.equals("<delete>") && pointer < result.length()) {
                        result.deleteCharAt(pointer);
                    } else if (conStructStr.equals("<bspace>") && (pointer - 1) > -1) {
                        result.deleteCharAt(pointer - 1);
                        pointer -= 1;
                    } else if (conStructStr.equals("<left>"))
                        pointer = Math.max(0, pointer - 1);
                    else if (conStructStr.equals("<right>"))
                        pointer = Math.min(result.length(), pointer + 1);
                    i = j;
                    break;
                }
                conStruct = new StringBuilder();
            } else {
                result.insert(pointer, log.charAt(i));
                pointer += 1;
            }

        }

        if (result.toString().equals(targetWord))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}