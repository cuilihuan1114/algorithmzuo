
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/30 11:04
 */

public class Problem_0965_单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        return process(root, set);
    }

    private boolean process(TreeNode root, HashSet<Integer> set) {
        if(root == null)
            return true;
        set.add(root.val);
        if(set.size() > 1)
            return false;

        return process(root.left, set) && process(root.right, set);
    }
}
