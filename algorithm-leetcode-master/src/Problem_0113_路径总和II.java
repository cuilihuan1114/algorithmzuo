import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/20 15:31
 */
public class Problem_0113_路径总和II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<Integer> curList = new LinkedList();
        process(root, sum, curList,list);
        return list;
    }

    private void process(TreeNode root, int sum, LinkedList<Integer> curList, List<List<Integer>> list) {
        curList.addLast(root.val);
        int remain = sum - root.val;
        if (root.left == null && root.right == null) {
            if(remain == 0){
                list.add(copy(curList));
            }
        }
        if(root.left!=null)
            process(root.left, remain, curList, list);
        if(root.right!=null)
            process(root.right, remain, curList, list);
        curList.removeLast();
    }

    private List<Integer> copy(LinkedList<Integer> curList) {
        LinkedList<Integer> newList = new LinkedList<>();
        for (int i = 0; i < curList.size(); i++) {
            newList.add(curList.get(i));
        }
        return newList;
    }
}
