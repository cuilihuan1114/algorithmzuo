import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/18 10:32
 */
public class Problem_0094_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        process(list,root);
        return list;
    }

    private void process(List<Integer> list, TreeNode root) {
        if(root == null)
            return;
        process(list,root.left);
        list.add(root.val);
        process(list,root.right);
    }
}
