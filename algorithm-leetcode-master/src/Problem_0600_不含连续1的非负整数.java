import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/21 15:36
 */
public class Problem_0600_不含连续1的非负整数 {
    public int findIntegers(int num) {
        int sum = 1;
        int one = 1;

        Map<String, Integer> map = new HashMap<>();
        return process(num, sum, one, map) + 1;
    }

    private int process(int n, int sum, int one, Map<String, Integer> map) {
        if (sum > n)
            return 0;

        String code = getCode(sum, one);
        if (map.containsKey(code))
            return map.get(code);

        int max = 1;
        if (one == 0)
            max += process(n, sum * 2 + 1, 1, map);
        max += process(n, sum * 2, 0, map);
        map.put(code, max);
        return max;
    }

    private String getCode(int sum, int one) {
        return sum + "_" + one;
    }
}
