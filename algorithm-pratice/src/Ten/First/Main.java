package Ten.First;

import java.util.Map;
import java.util.Scanner;


/**
 * @author cuilihuan
 * @data 2021/4/4 20:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j] = input.nextInt();
            }
        }
        long mod = (long) Math.pow(10, 9) + 7;
        long[] res = process(N, M, nums, mod, 0,0);
        long max = Math.max(res[0], res[1]);
        if(max < 0)
            System.out.println(-1);
        else
            System.out.println(max % mod);
    }

    public static long[] process(int N, int M, int[][] nums, long mod, int x, int y) {

        int cur = nums[x][y];
        if (x == N - 1 && y == M - 1)
            return new long[]{cur, cur};

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        if (x < N - 1) {
            long[] p1 = process(N, M, nums, mod, x + 1, y);
            max = Math.max(p1[0], Math.max(max, p1[1]));
            min = Math.min(p1[0], Math.min(min, p1[1]));
        }

        if (y < M - 1) {
            long[] p2 = process(N, M, nums, mod, x, y + 1);
            max = Math.max(p2[0], Math.max(max, p2[1]));
            min = Math.min(p2[0], Math.min(min, p2[1]));
        }
        max = max % mod;
        min = min % mod;
        return new long[]{cur * max, cur * min};

    }
}
