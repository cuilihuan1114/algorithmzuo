/**
 * @author cuilihuan
 * @data 2020/12/18 16:34
 */
public class Problem_0101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return process(root, root);
    }

    private boolean process(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null)
            return true;
        if (root != null && root1 != null) {
            return root.val == root1.val && process(root.left, root1.right) && process(root.right, root1.left);
        }
        return false;
    }
}
