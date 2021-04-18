import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/23 10:06
 */
public class Problem_0650_只有两个键的键盘 {
    public int minSteps(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;

        Map<String, Integer> map = new HashMap<>();
        return process(n, 1, 1, map) + 1;
    }

    private int process(int n, int copy, int cur, Map<String, Integer> map) {
        String code = getHashCode(copy, cur);
        if (map.containsKey(code))
            return map.get(code);
        if (cur > n)
            return -1;
        if (cur == n)
            return 0;
        int sum = Integer.MAX_VALUE;
        int p1 = process(n, copy, cur + copy, map);
        if (p1 != -1)
            sum = p1 + 1;
        int p2 = -1;
        if (copy != cur) {
            p2 = process(n, cur, cur, map);
        }
        if (p2 != -1)
            sum = Math.min(sum, p2 + 1);
        int ans = (sum == Integer.MAX_VALUE ? -1 : sum);
        map.put(code, ans);
        return ans;
    }

    private String getHashCode(int copy, int cur) {
        return copy + "_" + cur;
    }
}