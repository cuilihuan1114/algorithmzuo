/**
 * @author cuilihuan
 * @data 2020/12/20 14:14
 */
public class Problem_0108_将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        new Problem_0108_将有序数组转换为二叉搜索树().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if(start<mid)
            node.left = process(nums, start, mid - 1);
        if(mid<end)
            node.right = process(nums, mid + 1, end);
        return node;
    }
}
