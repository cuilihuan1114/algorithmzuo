import java.util.HashMap;
import java.util.Map;

/**
     * @author cuilihuan
     * @data 2021/4/8 10:46
     */
    public  class Problem_0123_买卖股票的最佳时机III {


        public static void main(String[] args) {
            System.out.println(new Problem_0123_买卖股票的最佳时机III().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        }

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;

    //        Map<String, Integer> map = new HashMap<>();
            return dp(2, prices);
        }


        public static int dp(int K, int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int N = prices.length;
            if (K >= N / 2) {
                return allTrans(prices);
            }
            int[][] dp = new int[N][K + 1];
            int ans = 0;
            for (int j = 1; j <= K; j++) {
                int t = dp[0][j - 1] - prices[0];
                for (int i = 1; i < N; i++) {
                    t = Math.max(t, dp[i][j - 1] - prices[i]);
                    dp[i][j] = Math.max(dp[i - 1][j], t + prices[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }

        public static int allTrans(int[] prices) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += Math.max(prices[i] - prices[i - 1], 0);
            }
            return ans;
        }

        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;

            Map<String, Integer> map = new HashMap<>();
            return process(prices, prices.length - 1, 2, map);
        }

        private int process(int[] prices, int index, int remain, Map<String, Integer> map) {

            String code = getHash(index, remain);
    //
            if (map.containsKey(code))
                return map.get(code);

            if (remain == 0)
                return 0;

            if (index == 0)
                return 0;

            int max = 0;
            int cur = prices[index];
            int p1 = 0;
            for (int i = index; i >= 0; i--) {
                p1 = cur - prices[i] + process(prices, i, remain - 1, map);
                max = Math.max(max, p1);
            }

            max = Math.max(max, process(prices, index - 1, remain, map));

            map.put(code, max);
            return max;


        }

        private String getHash(int index, int remain) {
            return index + "_" + remain;
        }


        public int maxProfit1(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;

            Map<String, Integer> map = new HashMap<>();
            return process1(prices, 0, 0, 2, map);
        }

        private int process1(int[] prices, int start, int index, int remain, Map<String, Integer> map) {

            String code = getCode(start, index, remain);

            if (map.containsKey(code))
                return map.get(code);

            if (remain == 0)
                return 0;

            if (index == prices.length)
                return 0;

            int max = 0;
            int cur = prices[index];
            int p1 = 0;
            for (int i = index; i >= start; i--) {
                p1 = cur - prices[i] + process1(prices, index, index + 1, remain - 1, map);
                max = Math.max(max, p1);
            }

            max = Math.max(max, process1(prices, start, index + 1, remain, map));

            map.put(code, max);
            return max;


        }

        private String getCode(int start, int index, int remain) {
            return start + "_" + index + "_" + remain;
        }
    }
