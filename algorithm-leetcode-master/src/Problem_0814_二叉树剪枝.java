
/**
 * @author cuilihuan
 * @data 2021/5/11 10:31
 */


public class Problem_0814_二叉树剪枝 {

    class Info {
        TreeNode treeNode;
        boolean flag = false;


        public Info() {
        }

        public Info(TreeNode treeNode, boolean flag) {
            this.treeNode = treeNode;
            this.flag = flag;
        }
    }


    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;

        return process(root).treeNode;
    }

    private Info process(TreeNode root) {
        if (root == null)
            return new Info(null, false);

        TreeNode cur = root;
        Info left = process(root.left);
        Info right = process(root.right);

        if (cur.val == 1) {
            if (!left.flag)
                cur.left = null;
            if (!right.flag)
                cur.right = null;
            return new Info(cur, true);
        } else {
            if (!left.flag && !right.flag)
                return new Info(null, false);
            if (!left.flag)
                cur.left = null;
            if (!right.flag)
                cur.right = null;
            return new Info(cur, true);
        }
    }
}
