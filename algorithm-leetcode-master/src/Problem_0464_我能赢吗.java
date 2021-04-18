import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/13 18:37
 */
public class Problem_0464_我能赢吗 {
    public static void main(String[] args) {
        System.out.println(new Problem_0464_我能赢吗().canIWin(20, 210));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            sum += i;
        }
        if (sum < desiredTotal)
            return false;
        int ans = 0;
        Map<Integer, boolean[]> map = new HashMap<>();
        return first(ans, maxChoosableInteger, desiredTotal, 0, map);
    }

    public boolean first(int ans, int maxChoosableInteger, int desiredTotal, int cur, Map<Integer, boolean[]> map) {
        boolean flag = false;

        if (map.containsKey(ans) && map.get(ans)[cur])
            return true;


        int pre = ans;
        for (int i = maxChoosableInteger; i >= 1; i--) {
            if (((ans >> i) & 1) == 0) {
                ans = ans + (1 << i);
                if (i + cur >= desiredTotal)
                    flag = true;
                if (!first(ans, maxChoosableInteger, desiredTotal, cur + i, map)) {
                    flag = true;
                }
                ans = pre;
                if (flag) {
                    break;
                }
            }
        }

        if (!map.containsKey(ans))
            map.put(ans, new boolean[500]);
        map.get(ans)[cur] = flag;
        return flag;
    }


}
