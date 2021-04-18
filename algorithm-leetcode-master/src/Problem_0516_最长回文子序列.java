 /**
     * @author cuilihuan
     * @data 2021/3/20 11:02
     */
    public  class Problem_0516_最长回文子序列 {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];

            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = 1;
            }

            //dp[i-1][j-1]
            int max = 1;
            for (int i = dp.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < dp.length; j++) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], dp[i + 1][j]));

                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }
    }