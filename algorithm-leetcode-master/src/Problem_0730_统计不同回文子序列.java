package D0414;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/8 20:27
 */
public class Problem_0730_统计不同回文子序列 {
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() == 0)
            return 0;
        int mod = 1000000007;
        int len = S.length();
        long[][] dp = new long[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (S.charAt(i) != S.charAt(j))
                    dp[i][j] = dp[i + 1][j]/*以i+1为起点，j为末尾的字符串回文数*/ + dp[i][j - 1]/*以i为起点，j - 1为末尾的字符串回文数*/ - dp[i + 1][j - 1]/*以i+1为起点，j-1为末尾的字符串回文数被统计了两次*/;
                else {
                    dp[i][j] = dp[i + 1][j - 1] * 2;
                    int l = i + 1, r = j - 1;
                    while (l <= r && S.charAt(l) != S.charAt(i)) l++; /* 从左侧开始查找相同的元素 */
                    while (l <= r && S.charAt(r) != S.charAt(j)) r--; /* 从右侧开始查找相同的元素 */
                    if (l > r) /* 没有找到重复字符 */
                        dp[i][j] += 2;
                    else if (l == r) /* 只有一个重复字符 */
                        dp[i][j] += 1;
                    else /* 找到重复字符了 */
                        dp[i][j] -= dp[l + 1][r - 1];
                }
                /* 在这里一定要注意
                这是因为dp[i][j]是一个取模后的值，会有可能减去取模前的值变成一个负数，所以直接用
                dp[i][j] %= mod 是不对的，这样会依然为负数，需要加上mod偏移量，保证在结果在0-mod之间。
                 */
                dp[i][j] = (dp[i][j] + mod) % mod;

            }
        }

        return (int)dp[0][len - 1];

    }





}
