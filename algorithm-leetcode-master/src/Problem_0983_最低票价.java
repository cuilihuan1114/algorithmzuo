
import java.util.TreeMap;

/**
 * @author cuilihuan
 * @data 2021/5/30 10:32
 */
public class Problem_0983_最低票价 {
    public static void main(String[] args) {
        System.out.println(new Problem_0983_最低票价().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0)
            return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < days.length; i++) {
            map.put(days[i], i);
        }
        int[] choose = {1, 7, 30};
        int[] dp = new int[366];
        return process(days,costs,choose,map,0,dp);
    }

    private int process(int[] days, int[] costs, int[] choose, TreeMap<Integer, Integer> map, int index,int[] dp) {
        if(index >= days.length)
            return 0;

        if(dp[index] != 0)
            return dp[index];

        int curDay = days[index];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < choose.length; i++) {
            int nextDay = curDay + choose[i] - 1;
            Integer key = map.higherKey(nextDay);
            if(key == null) {
                ans = Math.min(ans, costs[i]);
                continue;
            }
            int day = map.get(key);
            int p = process(days, costs, choose, map, day,dp);
            if(p != -1)
                ans = Math.min(ans,  p + costs[i]);
        }
        int res = ans == Integer.MAX_VALUE ? -1 : ans;
        dp[index] = ans;
        return res;
    }
}
