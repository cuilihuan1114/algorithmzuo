import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cuilihuan
 * @data 2020/12/19 10:16
 */
public class Problem_0103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = flag ? queue.pollFirst() : queue.pollLast();
                curList.add(root.val);
                if(flag){
                    if (root.left != null) {
                        queue.addLast(root.left);
                    }
                    if (root.right != null) {
                        queue.addLast(root.right);
                    }
                }else{
                    if (root.right != null) {
                        queue.addFirst(root.right);
                    }
                    if (root.left != null) {
                        queue.addFirst(root.left);
                    }
                }
            }
            list.add(curList);
            flag = !flag;
        }
        return list;
    }
}
