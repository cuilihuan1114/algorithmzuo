import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/13 10:27
 */
public class Problem_0491_递增子序列 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        LinkedList<Integer> curList = new LinkedList<>();
        process(nums, 0, curList, list);
        return list;
    }

    private void process(int[] nums, int index, LinkedList<Integer> curList, List<List<Integer>> list) {
        if (index == nums.length) {

            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!set.contains(nums[i]) && (curList.size() == 0 || nums[i] >= curList.get(curList.size() - 1))) {
                set.add(nums[i]);
                curList.addLast(nums[i]);
                if (curList.size() >= 2)
                    list.add(new ArrayList<>(curList));
                process(nums, i + 1, curList, list);
                curList.removeLast();
            }
        }
    }


    // 不能去掉排序
    private void process1(int[] nums, int index, LinkedList<Integer> curList, List<List<Integer>> list) {
        if (index == nums.length) {
            if (curList.size() >= 2)
                list.add(new ArrayList<>(curList));
            return;
        }

        if (curList.size() == 0 || nums[index] >= curList.get(curList.size() - 1)) {
            curList.add(nums[index]);
            process(nums, index + 1, curList, list);
            curList.removeLast();
        }

        process(nums, index + 1, curList, list);

    }
}
