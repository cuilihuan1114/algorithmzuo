package pdd.second;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/9 14:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int sum = N;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if (isHappy(sum)) {
                System.out.println(sum);
                flag = true;
                break;
            }
            sum += N;
        }
        if(!flag)
            System.out.println(-1);
    }

    private static boolean isHappy(int sum) {
        String s = String.valueOf(sum);
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '2' && s.charAt(i) <= '9') {
                int cur = s.charAt(i);
                if (pre != -1 && pre != cur) {
                    return false;
                } else if (pre == -1) {
                    pre = cur;
                }
            }
        }
        return true;
    }
}
