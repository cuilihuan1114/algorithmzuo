
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/18 16:09
 */
public class Problem_0787_K站中转内最便宜的航班 {


    public static void main(String[] args) {
        System.out.println(new Problem_0787_K站中转内最便宜的航班().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 3));
    }

    class City {
        int sno;
        HashMap<Integer, Integer> map = new HashMap<>();
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, City> flightMap = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            int length = flights[i][2];
            if (!flightMap.containsKey(start))
                flightMap.put(start, new City());
            City city = flightMap.get(start);
            city.map.put(end, length);
        }

        Map<String, Integer> cache = new HashMap<>();
        return process(flightMap, src, dst, K + 1, cache);
    }

    private int process(HashMap<Integer, City> flightMap, int src, int dst, int k, Map<String, Integer> cache) {

        String code = getString(src, k);
        if(cache.containsKey(code))
            return cache.get(code);

        if (src == dst)
            return 0;

        if (k == 0)
            return -1;

        int sum = Integer.MAX_VALUE;
        City city = flightMap.get(src);
        if(city == null)
            return -1;
        HashMap<Integer, Integer> map = city.map;
        for (Integer key : map.keySet()) {
            int p1 = process(flightMap, key, dst, k - 1, cache);
            if (p1 != -1) {
                sum = Math.min(sum, p1 + map.get(key));
            }
        }

        int res = (sum == Integer.MAX_VALUE ? -1 : sum);
        cache.put(code, res);
        return res;
    }

    private String getString(int src, int k) {
        return src + "_" + k;
    }
}
