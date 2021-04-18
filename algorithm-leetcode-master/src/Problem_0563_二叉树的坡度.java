/**
 * @author cuilihuan
 * @data 2021/3/21 15:15
 */




public class Problem_0563_二叉树的坡度 {
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        int[] max = new int[1];
        process(root, max);
        return max[0];
    }

    private int process(TreeNode root, int[] max) {
        if(root == null)
            return 0;
        int leftNum = process(root.left, max);
        int rightNum = process(root.right, max);

        max[0] += Math.abs(leftNum - rightNum);
        return leftNum + rightNum + root.val;
    }
}
