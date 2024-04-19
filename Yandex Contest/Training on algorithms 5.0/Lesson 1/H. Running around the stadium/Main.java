import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int L = Integer.MAX_VALUE, x1 = Integer.MAX_VALUE, v1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE, v2 = Integer.MAX_VALUE;

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                if (L == Integer.MAX_VALUE)
                    L = scanner.nextInt();
                else if (x1 == Integer.MAX_VALUE)
                    x1 = scanner.nextInt();
                else if (v1 == Integer.MAX_VALUE)
                    v1 = scanner.nextInt();
                else if (x2 == Integer.MAX_VALUE)
                    x2 = scanner.nextInt();
                else if (v2 == Integer.MAX_VALUE)
                    v2 = scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // If the runners start from one point, they don't have to run anywhere.
        if ((int) fixX(x1, L) == (int) fixX(x2, L))
            System.out.print("YES\n0.0000000000");
        // If the runners start from different points and with zero speeds, they will never reach each other
        else if (v1 == 0 && v2 == 0)
            System.out.print("NO");
        // Otherwise, we consider the minimum time
        else {
            int a1 = x1 + x2;
            int b1 = v1 + v2;

            int a2 = x1 - x2;
            int b2 = v1 - v2;

            double t = Double.MAX_VALUE;

            double t1 = getT(a1, b1, L);
            double t2 = getT(a2, b2, L);

            if (t1 > 0 && t2 < 0)
                t = t1;
            else if (t1 < 0 && t2 > 0)
                t = t2;
            else if (t1 > 0)
                t = Math.min(t1, t2);

            System.out.print(String.format("YES\n%.10f", t).replace(",", "."));
        }
    }


    // Counting the runner's position before the start of the lap
    private static double fixX(double x, int L) {
        if (x > (double) L / 2)
            return L - x;
        return x;
    }


    /**
     * Here is the solution of one of the solutions of the trigonometric equation:
     * <br></br>
     * <code>cos(x<sub>1</sub> + v<sub>1</sub> • t<sub>1</sub>) = cos(x<sub>2</sub> + v<sub>2</sub> • t<sub>2</sub>)</code>
     * <br></br>
     * It boils down to solving equations:
     * <br></br>
     * 1. <code>sin((x<sub>1</sub> + v<sub>1</sub> • t<sub>1</sub> + x<sub>2</sub> + v<sub>2</sub> • t<sub>2</sub>)/2) = 0</code> <br></br>
     * 2. <code>sin((x<sub>1</sub> + v<sub>1</sub> • t<sub>1</sub> - x<sub>2</sub> - v<sub>2</sub> • t<sub>2</sub>)/2) = 0</code> <br></br>
     * By revealing the sine, we get that in the general case it is necessary to solve the equation: <br></br>
     * <code>t = L • k/|b| + (-1) • a/b</code>, where <i>2 • П</i> is replaced by <i>L</i>, which is a complete turnover
     * in our case; <i>a</i> - is <code>x<sub>1</sub> ± x<sub>2</sub></code>, <i>b</i> -
     * is <code>v<sub>1</sub> ± v<sub>2</sub></code>. The period has a module in the denominator due to the
     * <a href="https://www.uznateshe.ru/kak-nayti-period-funktsii/">properties</a> of the period of the function <br></br>
     * To avoid an iterative way of finding the required <i>k</i>, equate our equation to zero and express
     * <i>k</i>. The result must be rounded up to an integer
     *
     * @param a is <code>x<sub>1</sub> ± x<sub>2</sub></code>
     * @param b is <code>v<sub>1</sub> ± v<sub>2</sub></code>
     * @param L the length of the stadium in meters
     * @return The lowest time value for the specified parameters <i>a</i> and <i>b</i>
     */
    private static double getT(int a, int b, int L) {
        // Avoiding division by zero
        if (b == 0)
            return -1;

        int k = (int) Math.ceil((float) a * Math.abs(b) / b / L);
        return (double) L * k / Math.abs(b) + (double) (-1) * a / b;
    }
}