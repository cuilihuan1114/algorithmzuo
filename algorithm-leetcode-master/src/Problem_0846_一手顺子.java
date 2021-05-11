
import java.util.TreeMap;

/**
 * @author cuilihuan
 * @data 2021/5/9 16:16
 */
public class Problem_0846_一手顺子 {

    public static void main(String[] args) {
        System.out.println(new Problem_0846_一手顺子().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }

    public boolean isNStraightHand(int[] hand, int W) {

        if (hand == null || hand.length == 0)
            return false;
        if (hand.length % W != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            if (map.containsKey(hand[i]))
                map.put(hand[i], map.get(hand[i]) + 1);
            else
                map.put(hand[i], 1);
        }

        while (!map.isEmpty()) {
            int key = map.firstKey();
            int value = map.get(key);
            for (int i = key; i < key + W; i++) {
                if(!map.containsKey(i))
                    return false;
                int cur = map.get(i);
                if(cur < value)
                    return false;
                else if(cur == value)
                    map.remove(i);
                else
                    map.put(i, map.get(i) - value);
            }
        }

        return true;
    }
}
