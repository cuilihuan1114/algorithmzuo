
import java.util.HashSet;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/5/27 15:04
 */
public class Problem_0904_水果成篮 {

    public static void main(String[] args) {
        System.out.println(new Problem_0904_水果成篮().totalFruit(new int[]{0,1,6,6,4,4,6}));
    }

    public int totalFruit(int[] tree) {
        if (tree == null || tree.length <= 2)
            return tree.length;

        int[] cache = new int[tree.length];
        cache[0] = 1;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == tree[i - 1])
                cache[i] = cache[i - 1] + 1;
            else
                cache[i] = 1;
        }

        int first = 0;
        int second = 1;
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        set.add(tree[0]);
        while (second < tree.length) {
            if (set.size() < 2 || set.contains(tree[second])) {
                set.add(tree[second]);
            } else {
                ans = Math.max(ans, second - first);
                set = new HashSet<>();
                set.add(tree[second - 1]);
                set.add(tree[second]);
                first = second - cache[second-1];
            }
            second++;

        }
        ans = Math.max(ans, second - first);
        return ans;
    }
}
