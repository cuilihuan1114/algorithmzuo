import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2020/12/19 10:52
 */
public class Problem_0105_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        System.out.println(new Problem_0105_从前序与中序遍历序列构造二叉树().buildTree(new int[]{3, 2, 1, 4},
                new int[]{1, 2, 3, 4}));

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        Map<Integer, Integer> inMap = new HashMap<>();


        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode process(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> inMap) {
        int preNum = preorder[preLeft];
        TreeNode root = new TreeNode(preNum);
        // 查找在中序的位置
        int inPostiton = inMap.get(preNum);

        int leftlen = inPostiton - inLeft;
        int newRight = preLeft + leftlen;
        if (inLeft <= inPostiton - 1)
            root.left = process(preorder, preLeft + 1, newRight, inorder, inLeft, inPostiton - 1, inMap);
        if (inPostiton + 1 <= inRight)
            root.right = process(preorder, newRight + 1, preRight, inorder, inPostiton + 1, inRight, inMap);
        return root;
    }
}
