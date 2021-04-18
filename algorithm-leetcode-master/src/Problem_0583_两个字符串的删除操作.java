/**
 * @author cuilihuan
 * @data 2021/3/21 17:04
 */
public class Problem_0583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        int max = 0;


        for (int i = 0; i < dp.length; i++) {
            if (word1.charAt(i) == word2.charAt(0))
                dp[i][0] = 1;
            else if (i != 0)
                dp[i][0] = dp[i - 1][0];
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 0; i < word2.length(); i++) {
            if (word1.charAt(0) == word2.charAt(i))
                dp[0][i] = 1;
            else if (i != 0)
                dp[0][i] = dp[0][i - 1];
            max = Math.max(max, dp[0][i]);

        }


        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                max = Math.max(max, dp[i][j]);
            }
        }

        return word1.length() + word2.length() - 2 * max;
    }
}