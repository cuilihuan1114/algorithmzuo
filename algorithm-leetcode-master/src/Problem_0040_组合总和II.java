import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/25 14:40
 */
public class Problem_0040_组合总和II {


    public static void main(String[] args) {
        System.out.println(new Problem_0040_组合总和II().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        process(list, candidates, target, cur, 0, 0);
        return list;

    }

    public void process(List<List<Integer>> list, int[] candidates, int target, LinkedList<Integer> cur, int index, int sum) {
        if (sum == target) {
            list.add(new ArrayList(cur));
            return;
        }
        if (index == candidates.length)
            return;

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                break;
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            cur.add(candidates[i]);
            process(list, candidates, target, cur, i + 1, sum + candidates[i]);
            cur.removeLast();
        }
    }
}
