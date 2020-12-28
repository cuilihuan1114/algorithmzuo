/**
 * @author cuilihuan
 * @data 2020/12/20 14:33
 */
public class Problem_0110_平衡二叉树 {
    class Info {
        boolean flag = true;
        int height = 0;

        Info(boolean flag, int height) {
            this.flag = flag;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).flag;
    }

    private Info process(TreeNode root) {
        if (root == null)
            return new Info(true, 0);
        Info left = process(root.left);
        Info right = process(root.right);
        boolean flag = left.flag && right.flag && (Math.abs(left.height - right.height) <= 1);
        int height = Math.max(left.height, right.height) + 1;
        return new Info(flag, height);
    }
}
