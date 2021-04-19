import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cuilihuan
 * @data 2021/3/23 9:01
 */
public class Problem_0646_最长数对链 {

    public static void main(String[] args) {
        System.out.println(new Problem_0646_最长数对链().findLongestChain(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] <= o2[0] ? -1 : 1;
            }
        });
        //        for (int i = 0; i < dp.length; i++) {
        //            dp[i] = 1;
        //        }


        int max = 1;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[j] + (pairs[j][1] < pairs[i][0] ? 1 : 0), dp[i]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
