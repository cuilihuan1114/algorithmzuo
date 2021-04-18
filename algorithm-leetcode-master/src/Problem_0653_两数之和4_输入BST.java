

import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/4/8 16:53
 */
public class Problem_0653_两数之和4_输入BST {

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

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> cur = getProcess(root);

        int left = 0;
        int right = cur.size() - 1;
        while (left < right){
            int p = cur.get(left) + cur.get(right);
            if( p > k ){
                right--;
            }else if(p < k){
                left++;
            }else
                return true;
        }
        return false;
    }

    private List<Integer> getProcess(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<Integer> left = getProcess(root.left);
        List<Integer> right = getProcess(root.right);
        List<Integer> res = new LinkedList<>();
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }
}
