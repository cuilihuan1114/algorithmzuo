
import java.util.LinkedList;

/**
 * @author cuilihuan
 * @data 2021/4/18 16:52
 */
public class Problem_0783_二叉搜索树节点最小距离 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int minDiffInBST(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        process(list, root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void process(LinkedList<Integer> list, TreeNode root) {
        if (root == null)
            return;
        process(list, root.left);
        list.addLast(root.val);
        process(list, root.right);
    }
}
