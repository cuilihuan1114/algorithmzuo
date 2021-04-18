/**
 * @author cuilihuan
 * @data 2021/3/6 17:32
 */
public class Problem_0404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        return process(root,false);
    }

    private int process(TreeNode root, boolean flag) {
        if(root == null)
            return 0;
        int res = 0;
        if(flag && root.left == null && root.right == null){
            res += root.val;
        }
        res += process(root.left, true);
        res += process(root.right, false);
        return res;
    }
}
