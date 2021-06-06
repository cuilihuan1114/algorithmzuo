
/**
 * @author cuilihuan
 * @data 2021/5/30 15:38
 */



public class Problem_0998_最大二叉树II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(root.val < val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
