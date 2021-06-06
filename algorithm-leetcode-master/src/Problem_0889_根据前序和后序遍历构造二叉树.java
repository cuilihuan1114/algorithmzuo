
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/5/26 19:07
 */

public class Problem_0889_根据前序和后序遍历构造二叉树 {

    public static void main(String[] args) {
        System.out.println(new Problem_0889_根据前序和后序遍历构造二叉树().constructFromPrePost(new int[]{
                1, 2, 4, 5, 3, 6, 7}, new int[]{
                4, 5, 2, 6, 7, 3, 1}));
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        HashMap<Integer, Integer> preMap = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            preMap.put(pre[i], i);
        }

        HashMap<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }

        return process(pre, preMap, 0, pre.length - 1, post, postMap, 0, post.length - 1);
    }

    private TreeNode process(int[] pre, HashMap<Integer, Integer> preMap, int preStart, int preEnd, int[] post, HashMap<Integer, Integer> postMap, int postStart, int postEnd) {

        if (postStart > postEnd || preStart > preEnd || postEnd >= post.length || preEnd >= pre.length)
            return null;

        if (postStart == postEnd)
            return new TreeNode(pre[preStart]);

        TreeNode root = new TreeNode(pre[preStart]);
        int midEnd = postMap.get(pre[preStart]);

        int prePos = preStart;
        int midPos = postMap.get(pre[preStart + 1]);

        int dis = midPos - postStart + 1;
        int preMid = prePos + dis;

        root.left = process(pre, preMap, preStart + 1, preMid, post, postMap, postStart, midPos);
        root.right = process(pre, preMap, preMid + 1, preEnd, post, postMap, midPos + 1, midEnd - 1);

        return root;
    }
}
