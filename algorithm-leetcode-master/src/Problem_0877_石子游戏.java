
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/11 14:49
 */
public class Problem_0877_石子游戏 {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        Map<String, Integer> cache = new HashMap<>();
        int ans = process(piles, 0, piles.length - 1,cache);
        return ans > sum - ans;
    }

    private int process(int[] piles, int start, int end, Map<String, Integer> cache) {
        String code = start + "_" + end;
        if(cache.containsKey(code))
            return cache.get(code);
        if (start > end)
            return 0;

        int max = 0;
        max = piles[start] + Math.min(process(piles, start + 2, end, cache), process(piles, start + 1, end - 1, cache));
        max = Math.max(max, piles[end] + Math.min(process(piles, start + 1, end - 1, cache), process(piles, start, end - 2, cache)));
        cache.put(code, max);
        return max;
    }

}
