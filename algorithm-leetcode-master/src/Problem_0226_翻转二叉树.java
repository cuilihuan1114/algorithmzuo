/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}
