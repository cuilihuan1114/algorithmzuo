
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/5/27 16:29
 */
public class Problem_0914_卡牌分组 {
    public static void main(String[] args) {
        System.out.println(new Problem_0914_卡牌分组().hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length < 2)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(Integer key : map.keySet()) {
            set.add(map.get(key));
            min = Math.min(min, map.get(key));
        }

        for (int i = min; i >= 2 ; i--) {
            boolean flag = true;
            for(Integer key : set){
                if(key % i != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }
}
