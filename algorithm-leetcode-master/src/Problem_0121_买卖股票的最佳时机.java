/**
 * @author cuilihuan
 * @data 2020/12/20 18:49
 */
public class Problem_0121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            }else
                min = prices[i];
        }
        return max;
    }
}
