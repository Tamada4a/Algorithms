import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int t_room = Integer.MAX_VALUE, t_cond = Integer.MAX_VALUE;
        String type = "";

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (t_room == Integer.MAX_VALUE) {
                    String[] split = line.split(" ");
                    t_room = Integer.parseInt(split[0]);
                    t_cond = Integer.parseInt(split[1]);
                } else {
                    type = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // The desired temperature is selected in the following cases:
        // 1) The operating mode of the air conditioner is set to "freeze" and the current temperature is higher than
        // desired, that is, the temperature will decrease.
        // 2) The operating mode of the air conditioner is set to "heat" and the current temperature is less than
        // desired, that is, the temperature will increase.
        // 3) The operating mode of the air conditioner is set to "auto", that is, the desired temperature will be
        // reached.
        if (type.equals("freeze") && t_room > t_cond || type.equals("heat") && t_room < t_cond || type.equals("auto")) {
            System.out.print(t_cond);
        }
        // Otherwise, we output the current temperature. This happens in the following cases:
        // 1) The operating mode of the air conditioner is set to "freeze" and the current temperature is less than
        // desired, that is, there is nothing to freeze.
        // 2) The operating mode of the air conditioner is set to "heat" and the current temperature is higher than
        // desired, that is, there is nothing to heat.
        // 3) The operating mode of the air conditioner is set to "fan" and the temperature does not change.
        else {
            System.out.print(t_room);
        }
    }
}