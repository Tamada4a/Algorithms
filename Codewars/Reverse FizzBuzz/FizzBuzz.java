import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<Integer> reverseFizzBuzz(String string) {
        // Fizz - the number is divisible by 3
        // Buzz - the number is divisible by 5
        // FizzBuzz - the number is divided by 15
        String[] split = string.split(" ");

        // Index and value of the last number
        int firstNumIdx = -1;
        int firstNumVal = -1;

        // Answer list
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate over all the elements of the split array
        for (int i = 0; i < split.length; ++i) {
            int newVal = -1;
            // If we have the index of the last number, we calculate the value of the current element
            if (firstNumIdx != -1) {
                newVal = firstNumVal + i - firstNumIdx;
            }
            // Otherwise, we calculate the value of the current element depending on the conditions
            else {
                // If there is only Fizz in the array, the current value is 3
                if (split[i].equals("Fizz") && split.length == 1)
                    newVal = 3;
                // If there is only Buzz in the array or Fizz is located after Buzz, the current
                // value is 5
                else if (split[i].equals("Buzz") && (split.length == 1 || split[i + 1].equals("Fizz")) && split.length < 3)
                    newVal = 5;
                // If Buzz is located in the array after Fizz, the current value is 9
                else if (split[i].equals("Fizz") && split[i + 1].equals("Buzz") && split.length < 3)
                    newVal = 9;
                // If there is only FizzBuzz in the array, the current value is 15
                else if (split[i].equals("FizzBuzz") && split.length == 1)
                    newVal = 15;
                // If the current element and the next one are any value from [Fizz, Buzz, FizzBuzz],
                // and the element with index i + 2 is a number, then subtract 2 from the (i + 2)th element
                else if (split.length > 2 && !isInteger(split[i]) && !isInteger(split[i + 1]) && isInteger(split[i + 2]))
                    newVal = Integer.parseInt(split[i + 2]) - 2;
                // If the current element is any value from [Fizz, Buzz, FizzBuzz], and the next element
                // is a number, then subtract 1 from the next element
                else if (split.length > 1 && !isInteger(split[i]) && isInteger(split[i + 1]))
                    newVal = Integer.parseInt(split[i + 1]) - 1;
                // Otherwise, if it is a number, we get the integer value of the element
                else if (isInteger(split[i]))
                    newVal = Integer.parseInt(split[i]);

                // We update the index and the value of the received number
                firstNumIdx = i;
                firstNumVal = newVal;
            }
            result.add(newVal);
        }
        return result;
    }


    // The function allows you to determine whether a string is a number
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
