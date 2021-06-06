
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/6/1 15:52
 */
public class Problem_0960_删列造序III {

    public static void main(String[] args) {
        System.out.println(new Problem_0960_删列造序III().minDeletionSize(new String[]{"babca", "bbazb"}));
    }

    public int minDeletionSize(String[] A) {
        int W = A[0].length();
        int[] dp = new int[W];
        Arrays.fill(dp, 1);
        for (int i = W - 2; i >= 0; --i)
            search:for (int j = i + 1; j < W; ++j) {
                for (String row : A)
                    if (row.charAt(i) > row.charAt(j))
                        continue search;

                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

        int kept = 0;
        for (int x : dp)
            kept = Math.max(kept, x);
        return W - kept;
    }


}
