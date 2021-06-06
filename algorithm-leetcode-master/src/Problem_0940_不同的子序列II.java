
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/5/28 21:07
 */
public class Problem_0940_不同的子序列II {
    public int distinctSubseqII(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int mod = 1_000_000_007;
        int ans = 0;
        int[] dp = new int[s.length() + 1];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans = (dp[i] * 2 % mod) - ((pos[c - 'a'] != -1 ? dp[pos[c - 'a']] : 0) % mod);
            ans %= mod;
            dp[i + 1] = ans;
            pos[c - 'a'] = i;
        }
        int res = --dp[s.length()];
        if (res < 0)
            res += mod;
        return res;
    }
}
