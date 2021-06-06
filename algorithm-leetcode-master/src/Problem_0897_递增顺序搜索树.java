
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/27 10:26
 */


public class Problem_0897_递增顺序搜索树 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return process1(list, 0);
    }

    private TreeNode process1(List<Integer> list, int index) {
        if(index == list.size())
            return null;
        TreeNode root = new TreeNode(list.get(index));
        root.right = process1(list, index + 1);
        return root;
    }

    private void process(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }
}
