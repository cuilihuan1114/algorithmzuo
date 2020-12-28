/**
 * @author cuilihuan
 * @data 2020/12/20 14:42
 */
public class Problem_0111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        int p = process(root);
        return p == Integer.MAX_VALUE ? 0 : p;

    }

    private int process(TreeNode root) {
        if(root == null)
            return Integer.MAX_VALUE;

        int left = process(root.left);
        int right = process(root.right);

        if(left == Integer.MAX_VALUE && right == Integer.MAX_VALUE)
            return 1;
        return Math.min(left , right) + 1;
    }
}
