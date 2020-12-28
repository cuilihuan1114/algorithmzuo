/**
 * @author cuilihuan
 * @data 2020/12/20 14:57
 */
public class Problem_0112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return process(root, sum);
    }

    private boolean process(TreeNode root, int sum) {
        if (root.left == null && root.right == null)
            return (sum-root.val) == 0;
        boolean left = false;
        if (root.left != null)
            left = process(root.left, sum - root.val);
        boolean right = false;
        if (root.right != null)
            right = process(root.right, sum - root.val);
        return left || right;
    }
}
