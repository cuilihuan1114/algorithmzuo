import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/3/6 15:24
 */
public class Problem_0403_青蛙过河 {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0)
            return true;
        int all = stones[stones.length - 1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            set.add(stones[i]);
        }
        HashMap<String, Boolean> cache = new HashMap<>();
        return process(0, 0, all, set,cache);
    }

    public String hash(int index,int k){
        return "index:" + index + "k:" + k;
    }

    private boolean process(int index, int k, int all, HashSet<Integer> set, HashMap<String, Boolean> cache) {

        String hash = hash(index, k);
        if(cache.containsKey(hash))
            return cache.get(hash);

        if (index >= all) {
            return index == all;
        }


        cache.put(hash, true);
        if (k > 0 && set.contains(index + k)) {
            if (process(index + k, k, all, set,cache)) {
                return true;
            }
        }

        if (k > 1 && set.contains(index + k - 1)) {
            if (process(index + k - 1, k - 1, all, set,cache))
                return true;
        }

        if (set.contains(index + k + 1) && process(index + k + 1, k + 1, all, set,cache))
            return true;

        cache.put(hash, false);
        return false;
    }
}
