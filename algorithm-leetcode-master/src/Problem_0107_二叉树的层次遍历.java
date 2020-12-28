import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cuilihuan
 * @data 2020/12/20 13:57
 */
public class Problem_0107_二叉树的层次遍历 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> allList = new ArrayList<>();
        if (root == null)
            return allList;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> sizeList = new LinkedList<>();
        LinkedList<Integer> valList = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            sizeList.add(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                valList.add(node.val);
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
        }

        while (!sizeList.isEmpty()){
            int size = sizeList.pollLast();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(valList.pollLast());
            }
            allList.add(list);
        }
        return allList;
    }
}
