/**
 * @author cuilihuan
 * @data 2020/12/20 16:34
 */
public class Problem_0124_二叉树中的最大路径和 {

    class Info {
        int max = Integer.MIN_VALUE;
        int rootMax = Integer.MIN_VALUE;

        public Info(int max, int rootMax) {
            this.max = max;
            this.rootMax = rootMax;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        return process(root).max;

    }

    private Info process(TreeNode root) {
        if (root == null)
            return new Info(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Info left = process(root.left);
        Info right = process(root.right);
        int max = Math.max(left.max, right.max);

        int p0 = root.val;
        int p1 = (left.rootMax == Integer.MIN_VALUE ? 0 : left.rootMax) + root.val;
        int p2 = (right.rootMax == Integer.MIN_VALUE ? 0 : right.rootMax) + root.val;
        int p3 = p1 + p2 - p0;

        int rootMax = Math.max(p0, Math.max(p1, p2));
        max = Math.max(max, Math.max(rootMax,p3));
        return new Info(max, rootMax);
    }
}
