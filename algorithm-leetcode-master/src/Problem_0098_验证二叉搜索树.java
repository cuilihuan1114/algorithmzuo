import jdk.nashorn.internal.ir.ThrowNode;

/**
 * @author cuilihuan
 * @data 2020/12/18 15:51
 */
public class Problem_0098_验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(new Problem_0098_验证二叉搜索树().isValidBST(root));
    }

    class Info {
        int min;
        int max;
        boolean flag = true;

        public Info(int min, int max, boolean flag) {
            this.max = max;
            this.min = min;
            this.flag = flag;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return process(root).flag;
    }

    private Info process(TreeNode root) {
        if (root == null)
            return null;
        Info left = process(root.left);
        Info right = process(root.right);
        boolean flag = true;
        int min = root.val;
        int max = root.val;
        if (left != null) {
            flag = left.flag;
            flag = flag && (root.val > left.max);
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            flag = flag && right.flag;
            flag = flag && (root.val < right.min);
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        return new Info(min, max, flag);
    }
}
