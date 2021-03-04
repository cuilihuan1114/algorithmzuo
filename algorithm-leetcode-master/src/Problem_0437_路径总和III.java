import java.util.HashMap;

/**
 * Created by CUI on 2021/2/27
 */
public class Problem_0437_路径总和III {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int all = 0;
        int[] count = new int[1];
        process(root, sum, all, map,count);
        return count[0];
    }

    private void process(TreeNode root, int target, int sum, HashMap<Integer, Integer> map, int[] count) {
        if(root == null)
            return;
        sum += root.val;
        if(map.containsKey(sum - target)){
            count[0] += map.get(sum - target);
        }
        if(map.containsKey(sum)){
            map.put(sum, map.get(sum) + 1);
        }else
            map.put(sum, 1);

        process(root.left, target, sum, map, count);
        process(root.right, target, sum, map, count);

        if(map.get(sum) > 1){
            map.put(sum, map.get(sum) - 1);
        }else
            map.remove(sum);
    }
}
