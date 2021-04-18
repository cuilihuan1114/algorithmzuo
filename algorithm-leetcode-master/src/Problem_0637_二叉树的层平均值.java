import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/23 16:37
 */



public class Problem_0637_二叉树的层平均值 {
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

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        if (root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int count = 1;
        int pre = count;
        int cur = 0;
        double sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            count--;
            sum += node.val;
            if (node.left != null) {
                queue.addLast(node.left);
                cur++;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                cur++;
            }

            if (count == 0) {
                list.add( sum / pre);
                count = cur;
                pre = cur;
                cur = 0;
                sum = 0;
            }

        }
        return list;

    }
}
