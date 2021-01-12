/**
 * Created by CUI on 2021/1/9
 */
public class Problem_0236_二叉树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(7);
        left.right = new TreeNode(4);
        System.out.println(new Problem_0236_二叉树的最近公共祖先().lowestCommonAncestor(root, left, left.right).val);
    }

    class Info{
        boolean isP;
        boolean isQ;
        TreeNode sameRoot = null;

        public Info(boolean isP, boolean isQ, TreeNode sameRoot) {
            this.isP = isP;
            this.isQ = isQ;
            this.sameRoot = sameRoot;
        }

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        return process(root, p, q).sameRoot;
    }

    private Info process(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        Info left = process(root.left, p, q);
        Info right = process(root.right, p, q);
        boolean isP = false;
        boolean isQ = false;
        TreeNode sameNode = null;
        if (left != null) {
            isP = left.isP;
            isQ = left.isQ;
            sameNode = left.sameRoot;
        }
        if (right != null) {
            isP = isP || right.isP;
            isQ = isQ || right.isQ;
            if(sameNode == null)
                sameNode = right.sameRoot;
        }
        if(sameNode!=null)
            return new Info(true, true, sameNode);
        if(!isP && p == root)
            isP = true;
        if(!isQ && q == root)
            isQ = true;
        if(isP && isQ)
            sameNode = root;
        return new Info(isP, isQ, sameNode);
    }
}
