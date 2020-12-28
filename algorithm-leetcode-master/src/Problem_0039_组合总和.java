import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/25 16:07
 */
public class Problem_0039_组合总和 {
    public static void main(String[] args) {
        System.out.println(new Problem_0039_组合总和().combinationSum(new int[]{2, 6}, 6));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return null;
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        process(list, candidates, target, cur, 0, 0);
        return list;

    }

    public void process(List<List<Integer>> list, int[] candidates, int target, List<Integer> cur, int index, int sum) {
        if (sum == target) {
            list.add(cur);
            return;
        }
        if (index == candidates.length || sum > target)
            return;
        List<Integer> now = new LinkedList<>(cur);
        for (int i = 0; candidates[index] * i + sum <= target; i++) {
            if (i == 0) {
                process(list, candidates, target, now, index + 1, sum);
                continue;
            }
            now.add(candidates[index]);
            process(list, candidates, target, now, index + 1, sum+candidates[index]*i);
        }
    }
}
