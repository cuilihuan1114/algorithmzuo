import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/4/13 9:27
 */
public class Problem_0771_宝石与石头 {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i)))
                count++;
        }

        return count;
    }
}