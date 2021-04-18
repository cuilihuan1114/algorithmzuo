import java.util.*;

/**
 * @author cuilihuan
 * @data 2020/12/2 20:13
 */
public class Problem_0687_最长同值路径 {
    class Info{
        int max = 1;
        int len = 1;

        public Info(int max, int len) {
            this.max = max;
            this.len = len;
        }
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        return process(root).max - 1;
    }

    private Info process(TreeNode root) {
        if(root == null)
            return new Info(0, 0);
        Info left = process(root.left);
        Info right = process(root.right);

        int max = Integer.MIN_VALUE;
        max = Math.max(Math.max(left.max, max), right.max);

        int len = 1;
        int curLen = 1;

        if (root.left != null) {
            len += (root.val == root.left.val) ? left.len : 0;
            curLen = len;
        }

        if (root.right != null) {
            len += (root.val == root.right.val) ? right.len : 0;
            curLen = (curLen != len) ? (Math.max(curLen, right.len + 1)) : curLen;
        }

        max = Math.max(len, max);
        return new Info(max,curLen);
    }



}
