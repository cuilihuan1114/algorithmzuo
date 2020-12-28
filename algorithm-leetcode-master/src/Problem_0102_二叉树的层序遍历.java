import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cuilihuan
 * @data 2020/12/18 17:08
 */
public class Problem_0102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        process(list,root);
        return list;
    }

    private void process(List<List<Integer>> list, TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int size = 1;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int index = 0;
            int nextSize = 0;
            while (index < size){
                TreeNode node = queue.pop();
                curList.add(node.val);
                index++;
                if(node.left!=null){
                    queue.addLast(node.left);
                    nextSize++;
                }
                if(node.right!=null){
                    queue.addLast(node.right);
                    nextSize++;
                }
            }
            list.add(curList);
            size = nextSize;
        }
    }
}
