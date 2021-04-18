import java.util.*;

/**
 * Created by CUI on 2021/2/27
 */
public class Problem_0647_回文子串 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] sToChar = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i < s.length() - 1 && sToChar[i] == sToChar[i + 1])
                dp[i][i + 1] = 1;
        }

        for (int i = dp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                if (sToChar[i] == sToChar[j] && dp[i + 1][j - 1] == 1)
                    dp[i][j] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                count += dp[i][j];
            }
        }
        return count;


    }

}
