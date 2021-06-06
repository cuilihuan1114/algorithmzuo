
/**
 * @author cuilihuan
 * @data 2021/5/29 14:29
 */


public class Problem_0951_翻转等价二叉树 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;

        return process(root1, root2);
    }

    private boolean process(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if(root1.val != root2.val)
            return false;

        boolean flag = false;
        flag |= process(root1.left, root2.left) && process(root1.right,root2.right);
        if(flag)
            return true;
        flag |= process(root1.right, root2.left) && process(root1.left, root2.right);

        return flag;

    }
}
