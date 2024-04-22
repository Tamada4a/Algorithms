import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int N = Integer.MAX_VALUE, year = Integer.MAX_VALUE;

        // All holiday dates are stored here
        ArrayList<String> holidays = new ArrayList<>();

        // Index of the first day of the year
        int firstDayOfWeek = 0;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (N == Integer.MAX_VALUE)
                    N = Integer.parseInt(line);
                else if (year == Integer.MAX_VALUE)
                    year = Integer.parseInt(line);
                else if (line.contains(" "))
                    holidays.add(line.toUpperCase(Locale.ROOT));
                else
                    firstDayOfWeek = getDayOfWeek(year, new String[]{"1", "JANUARY"});
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // An array containing the number of working days in a week
        // Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
        int[] holidayDays = {52, 52, 52, 52, 52, 52, 52};

        // Adding a working day on the first day of the year
        holidayDays[firstDayOfWeek] += 1;

        // If the year is a leap year, we add another working day
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
            holidayDays[(firstDayOfWeek + 1) % 7] += 1;

        // For each holiday, we get the day of the week and reduce its value, since it is a day off
        for (String holidayDate : holidays) {
            int dayOfWeek = getDayOfWeek(year, holidayDate.split(" "));

            holidayDays[dayOfWeek] -= 1;
        }

        // We are looking for the maximum and minimum in our array - restDay and hardWorkDay
        // On restDay, as the busiest, you need to take a day off
        int min = holidayDays[0];
        int max = min;

        int restDay = 0; // The day of the week on which you should take a day off
        int hardWorkDay = 0; // The day of the week on which you will have to work the most
        for (int i = 1; i < 7; i++) {
            if (holidayDays[i] < min) {
                min = holidayDays[i];
                hardWorkDay = i;
            } else if (holidayDays[i] > max) {
                max = holidayDays[i];
                restDay = i;
            }
        }

        System.out.printf("%s %s", getDayOfWeekNameByIndex(restDay), getDayOfWeekNameByIndex(hardWorkDay));
    }


    // We get the day of the week by date
    private static int getDayOfWeek(int year, String[] holidayDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(Date.valueOf(LocalDate.of(year, Month.valueOf(holidayDate[1]), Integer.parseInt(holidayDate[0]))));
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }


    // We get the name of the day of the week by the index
    private static String getDayOfWeekNameByIndex(int index) {
        return switch (index) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }
}