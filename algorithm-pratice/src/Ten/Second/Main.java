package Ten.Second;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/4 20:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        for (int i = 0; i < N; i++) {
            double l = input.nextInt();
            double r = input.nextInt();
            double k = input.nextInt();
            double sum = 0;
            for (double j = l; j <= r; j++) {
                sum += Math.pow(j + Math.pow(10, -k) - Math.pow(j, 1.0 / 3), 1.0 / 3);
            }
            System.out.println(sum);

        }
    }
}
