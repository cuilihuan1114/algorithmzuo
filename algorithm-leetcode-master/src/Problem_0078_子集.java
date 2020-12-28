import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/5 14:32
 */
public class Problem_0078_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if(nums == null || nums.length == 0)
            return list;
        LinkedList<Integer> path = new LinkedList<>();
        process(nums, list, 0,path);
        return list;
    }

    private void process(int[] nums, List<List<Integer>> list, int index, LinkedList<Integer> path) {
        if (nums.length == index) {
            list.add(copyList(path));
            return;
        }
        process(nums, list, index + 1, path);
        path.add(nums[index]);
        process(nums, list, index + 1, path);
        path.removeLast();
    }

    private List<Integer> copyList(List<Integer> path) {
        List<Integer> list = new LinkedList<>();
        for (Integer cur :
                path) {
            list.add(cur);
        }
        return list;
    }
}
