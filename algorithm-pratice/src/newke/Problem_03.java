package newke;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/3/18 20:23
 */
public class Problem_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s1 = input.next();
        String s2 = input.next();
        String s3 = input.next();
        int[][] count = new int[3][26];
        for (int i = 0; i < s1.length(); i++) {
            count[0][s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[1][s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s3.length(); i++) {
            count[2][s3.charAt(i) - 'a']++;
        }

        int len = s1.length();
        int[] res = new int[3];
        if (n == len) {
            System.out.println("draw");
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 26; j++) {
                    if (n + count[i][j] <= len) {
                        res[i] = Math.max(res[i], n + count[i][j]);
                    } else {
                        res[i] = 8 - ((n + count[i][j]) % 2 == 0 ? 0 : 1);
                    }
                }
            }
        }

        int max = 0;
        boolean falg = false;
        for (int i = 0; i < res.length; i++) {
            max = Math.max(res[i], max);
        }

        int num = -1;

        for (int i = 0; i < res.length; i++) {
            if (max == res[i] && num == -1) {
                num = i;
            } else {
                falg = true;
                System.out.println("draw");
            }
        }

        String[] s = new String[]{"xiaoming", "xiaowang", "xiaoli"};
        if (!falg)
            System.out.println(s[num]);

    }
}
