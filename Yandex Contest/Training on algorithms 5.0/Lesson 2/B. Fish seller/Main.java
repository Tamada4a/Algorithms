import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // В данных переменных будут храниться соответствующие значения
        int k = Integer.MAX_VALUE, n = Integer.MAX_VALUE;

        ArrayList<Integer> prices = new ArrayList<>();
        // Считываем данные
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (n == Integer.MAX_VALUE)
                    n = scanner.nextInt();
                else if (k == Integer.MAX_VALUE)
                    k = scanner.nextInt();
                else
                    prices.add(scanner.nextInt());
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        int max = 0;
        // Для каждых k элементов считаем разность и сравниваем с максимумом
        for (int i = 0; i < n - 1; ++i) {
            int end;
            if (n - i - 1 >= k)
                end = i + k + 1;
            else
                end = n;

            for (int ki = i + 1; ki < end; ++ki) {
                int dif = prices.get(ki) - prices.get(i);
                if (dif > max)
                    max = dif;
            }
        }
        System.out.print(max);
    }
}