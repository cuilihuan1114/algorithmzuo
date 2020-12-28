import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/22 15:25
 */
public class Problem_0129_求根到叶子节点数字之和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Problem_0129_求根到叶子节点数字之和().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        List<Integer> list = new ArrayList<>();
        process(root, list, 0);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    private void process(TreeNode root, List<Integer> list, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            list.add(num);
            return;
        }
        if (root.left != null)
            process(root.left, list, num);
        if (root.right != null)
            process(root.right, list, num);
    }
}
