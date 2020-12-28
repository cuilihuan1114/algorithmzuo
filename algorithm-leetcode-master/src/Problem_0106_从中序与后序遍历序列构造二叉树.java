import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2020/12/20 13:34
 */
public class Problem_0106_从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        new Problem_0106_从中序与后序遍历序列构造二叉树().buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return process(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

    }

    private TreeNode process(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        int treeVal = postorder[postEnd];
        int inPosition = map.get(treeVal);
        TreeNode root = new TreeNode(treeVal);
        int leftLength = inPosition - inStart-1;
        if (inPosition > inStart) {
            root.left = process(inorder, inStart, inPosition - 1, postorder, postStart, postStart + leftLength, map);
        }
        if(inPosition < inEnd){
            root.right = process(inorder, inPosition + 1, inEnd, postorder, postStart + leftLength + 1, postEnd - 1, map);
        }
        return root;
    }
}
