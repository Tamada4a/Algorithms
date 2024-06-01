import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // В данных переменных будут храниться соответствующие значения
        int n = Integer.MAX_VALUE, a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, k = Integer.MAX_VALUE;

        // Здесь хранятся значения каждого сектора
        ArrayList<Integer> sectors = new ArrayList<>();

        // Считываем данные
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (n == Integer.MAX_VALUE)
                    n = scanner.nextInt();
                else if (sectors.size() != n)
                    sectors.add(scanner.nextInt());
                else if (a == Integer.MAX_VALUE)
                    a = scanner.nextInt();
                else if (b == Integer.MAX_VALUE)
                    b = scanner.nextInt();
                else
                    k = scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Считаем минимальное и максимальное количество секторов, которое мы можем пройти
        int minSpins = (a - 1) / k, maxSpins = (b - 1) / k;

        // Корректируем границы, если мы совершаем полные обороты
        if (maxSpins - minSpins >= n - 1)
            maxSpins = n - 1 + minSpins;

        // Считаем максимум
        int max = 0;
        for (int i = minSpins; i <= maxSpins; ++i)
            max = Math.max(max, Math.max(sectors.get(i % n), sectors.get(n - (n + i - 1) % n - 1)));

        System.out.print(max);
    }
}