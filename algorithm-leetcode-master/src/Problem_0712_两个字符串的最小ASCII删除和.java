/**
     * @author cuilihuan
     * @data 2021/4/11 15:50
     */
    public  class Problem_0712_两个字符串的最小ASCII删除和 {
        public static void main(String[] args) {
            System.out.println(new Problem_0712_两个字符串的最小ASCII删除和().minimumDeleteSum("delete", "leet"));
        }

        //改成动态规划
        public int minimumDeleteSum(String s1, String s2) {
            if (s1 == null && s2 == null)
                return 0;
            int sum = 0;
            if (s1 == null) {
                for (int i = 0; i < s2.length(); i++) {
                    sum += s2.charAt(i);
                }
                return sum;
            }
            if (s2 == null) {
                for (int i = 0; i < s1.length(); i++) {
                    sum += s1.charAt(i);
                }
                return sum;
            }
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            dp[s1.length()][s2.length()] = 0;
            for (int i = s2.length() - 1; i >= 0; i--) {
                dp[s1.length()][i] = s2.charAt(i) + dp[s1.length()][i + 1];
            }

            for (int i = s1.length() - 1; i >= 0; i--) {
                dp[i][s2.length()] = s1.charAt(i) + dp[i + 1][s2.length()];
            }
            for (int index1 = s1.length() - 1; index1 >= 0 ; index1--) {
                for (int index2 = s2.length() - 1; index2 >= 0 ; index2--) {
                    int ans = Integer.MAX_VALUE;
                    int p1 = 0;
                    if (s1.charAt(index1) == s2.charAt(index2)) {
                        p1 = dp[index1 + 1][index2 + 1];
                        ans = Math.min(ans, p1);
                    }
                    int p2 = s1.charAt(index1) + dp[ index1 + 1][index2];
                    ans = Math.min(ans, p2);
                    int p3 = s2.charAt(index2) + dp[index1] [index2 + 1];
                    ans = Math.min(ans, p3);
                    dp[index1][index2] = ans;
                }
            }
            return dp[0][0];

        }


        public int minimumDeleteSum2(String s1, String s2) {
            if (s1 == null && s2 == null)
                return 0;
            int sum = 0;
            if (s1 == null) {
                for (int i = 0; i < s2.length(); i++) {
                    sum += s2.charAt(i);
                }
                return sum;
            }
            if (s2 == null) {
                for (int i = 0; i < s1.length(); i++) {
                    sum += s1.charAt(i);
                }
                return sum;
            }
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];

            return process(s1, s2, 0, 0, dp);
        }

        private int process(String s1, String s2, int index1, int index2, int[][] dp) {
            if (dp[index1][index2] > 0)
                return dp[index1][index2];
            if (index1 == s1.length() && index2 == s2.length())
                return 0;
            if (index1 == s1.length()) {
                return s2.charAt(index2) + process(s1, s2, index1, index2 + 1, dp);
            }
            if (index2 == s2.length()) {
                return s1.charAt(index1) + process(s1, s2, index1 + 1, index2, dp);
            }

            int ans = Integer.MAX_VALUE;
            int p1 = 0;
            if (s1.charAt(index1) == s2.charAt(index2)) {
                p1 = process(s1, s2, index1 + 1, index2 + 1, dp);
                ans = Math.min(ans, p1);
            }
            int p2 = s1.charAt(index1) + process(s1, s2, index1 + 1, index2, dp);
            ans = Math.min(ans, p2);
            int p3 = s2.charAt(index2) + process(s1, s2, index1, index2 + 1, dp);
            ans = Math.min(ans, p3);

            dp[index1][index2] = ans;
            return ans;

        }

        //错误的动态规划
        public int minimumDeleteSum1(String s1, String s2) {
            if (s1 == null && s2 == null)
                return 0;
            int sum = 0;
            if (s1 == null) {
                for (int i = 0; i < s2.length(); i++) {
                    sum += s2.charAt(i);
                }
                return sum;
            }
            if (s2 == null) {
                for (int i = 0; i < s1.length(); i++) {
                    sum += s1.charAt(i);
                }
                return sum;
            }

            int[][] dp = new int[s1.length()][s2.length()];

            boolean flag = false;
            sum = 0;
            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(0) == s2.charAt(i) && !flag) {
                    flag = true;
                } else
                    sum += s2.charAt(i);
                dp[0][i] = sum + s1.charAt(0);
            }

            flag = false;
            sum = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s2.charAt(0) == s1.charAt(i) && !flag) {
                    flag = true;
                } else
                    sum += s1.charAt(i);
                dp[i][0] = sum + s2.charAt(0);
            }

            for (int i = 1; i < s1.length(); i++) {
                for (int j = 1; j < s2.length(); j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        sum = dp[i - 1][j - 1];
                    } else {
                        sum = dp[i - 1][j - 1] + s1.charAt(i) + s2.charAt(j);
                    }

                    sum = Math.min(sum, dp[i - 1][j] + s1.charAt(i));
                    sum = Math.min(sum, dp[i][j - 1] + s2.charAt(j));
                    dp[i][j] = sum;
                }
            }

            return dp[s1.length() - 1][s2.length() - 1];

        }
    }