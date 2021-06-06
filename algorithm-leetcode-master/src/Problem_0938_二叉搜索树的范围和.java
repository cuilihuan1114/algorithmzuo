
/**
 * @author cuilihuan
 * @data 2021/5/28 20:46
 */

public class Problem_0938_二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        int[] ans = new int[1];
        process1(root, low, high, ans);
        return ans[0];
    }

    private void process1(TreeNode root, int low, int high, int[] ans) {
        if(root == null )
            return;
        if(root.val >= low && root.val <= high){
            ans[0] += root.val;

        }
        process1(root.left, low, high, ans);
        process1(root.right, low, high, ans);
    }

    private void process(TreeNode root, int low, int high, int[] ans) {
        if(root == null )
            return;
        if(root.val >= low && root.val <= high){
            ans[0] += root.val;
            process(root.left, low, high, ans);
            process(root.right, low, high, ans);
        }else if(root.val < low){
            process(root.right, low, high, ans);
        }else {
            process(root.left, low, high, ans);
        }
    }
}
