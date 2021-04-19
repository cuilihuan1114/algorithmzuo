package newke;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/3/18 20:02
 */
public class Problem_02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                left[i] = (i != 0 ? left[i - 1] : 0) + 1;
            else
                left[i] = i != 0 ? left[i - 1] : 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                right[i] = (i != n - 1 ? right[i + 1] : 0) + 1;
            else
                right[i] = i != n - 1 ? right[i + 1] : 0;
        }

        int min = right[0];

        for (int i = 0; i < n; i++) {
            int leftZero = (i + 1) - left[i];
            int rightOne = i+1 != n ? right[i + 1] : 0;
            min = Math.min(min, leftZero + rightOne);
        }

        System.out.println(min);

    }
}
