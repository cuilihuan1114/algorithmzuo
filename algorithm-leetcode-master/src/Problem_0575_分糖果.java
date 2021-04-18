import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/3/21 16:35
 */
public class Problem_0575_分糖果 {
    public int distributeCandies(int[] candyType) {
        if(candyType == null || candyType.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        int cout = 0;
        for (int i = 0; i < candyType.length; i++) {
            if(!set.contains(candyType[i])){
                cout++;
                set.add(candyType[i]);
            }
        }

        return Math.min(cout, candyType.length / 2);
    }
}
