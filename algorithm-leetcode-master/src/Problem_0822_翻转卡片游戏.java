
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/5/10 19:43
 */
public class Problem_0822_翻转卡片游戏 {


    public static void main(String[] args) {
        System.out.println(new Problem_0822_翻转卡片游戏().flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{
                1, 3, 4, 1, 3}));
    }

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet();
        for (int i = 0; i < fronts.length; ++i)
            if (fronts[i] == backs[i])
                same.add(fronts[i]);

        int ans = 9999;
        for (int x: fronts)
            if (!same.contains(x))
                ans = Math.min(ans, x);

        for (int x: backs)
            if (!same.contains(x))
                ans = Math.min(ans, x);

        return ans % 9999;
    }


    //有错。。。。
    public int flipgame1(int[] fronts, int[] backs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fronts.length; i++) {
            map.put(fronts[i], map.getOrDefault(fronts[i], 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < backs.length; i++) {
            int X = backs[i];
            map.put(fronts[i], map.getOrDefault(fronts[i], 0) - 1);
            map.put(X, map.getOrDefault(X, 0) + 1);

            int cur = fronts[i];
            for (int j = 0; j < backs.length; j++) {
                cur = backs[j];
                if (j == i)
                    cur = fronts[i];
                if (!map.containsKey(cur) || map.get(cur) <= 0)
                    min = Math.min(min, cur);
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}

