
/**
 * @author cuilihuan
 * @data 2021/6/1 14:12
 */


public class Problem_0993_二叉树的堂兄弟节点 {
    class Info{
        TreeNode root;
        int p;

        public Info(TreeNode root, int p) {
            this.root = root;
            this.p = p;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Info p1 = process(root, x);
        Info p2 = process(root, y);
        if (p2 != null &&  p1!= null && p1.p ==  p2.p && p1.root != p2.root)
            return true;
        return false;
    }

    private Info process(TreeNode root, int num) {
        if (root == null)
            return null;
        if (root.val == num)
            return new Info(null, 0);
        Info p1 = process(root.left, num);
        if (p1 != null) {
            if(p1.p == 0)
                return new Info(root, p1.p + 1);
            else
                return new Info(p1.root, p1.p + 1);
        }

        p1 = process(root.right, num);
        if (p1 != null) {
            if(p1.p == 0)
                return new Info(root, p1.p + 1);
            else
                return new Info(p1.root, p1.p + 1);
        }
        return null;
    }
}
