/**
 * @author cuilihuan
 * @data 2020/12/19 10:48
 */
public class Problem_0104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
