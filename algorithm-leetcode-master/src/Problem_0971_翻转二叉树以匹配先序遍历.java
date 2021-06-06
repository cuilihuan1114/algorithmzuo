
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/30 14:17
 */


public class Problem_0971_翻转二叉树以匹配先序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new Problem_0971_翻转二叉树以匹配先序遍历().flipMatchVoyage(root, new int[]{1, 2, 3}));
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < voyage.length; i++) {
            map.put(voyage[i], i);
        }

        boolean flag = process(root, map, list, voyage, 0, voyage.length - 1);
        if (!flag) {
            list = new ArrayList<>();
            list.add(-1);
        }
        return list;
    }

    private boolean process(TreeNode root, HashMap<Integer, Integer> map, List<Integer> list, int[] voyage, int start, int end) {
        if (root == null)
            return start == -1;

        if (start == -1 || root.val != voyage[start])
            return false;


        int leftPos = -1;
        if (root.left != null) {
            leftPos = map.get(root.left.val);
            if (leftPos < start || leftPos > end)
                return false;
        }

        int rightPos = -1;
        if (root.right != null) {
            rightPos = map.get(root.right.val);
            if (rightPos < start || rightPos > end)
                return false;
        }

        if (rightPos != -1 && leftPos > rightPos) {
            list.add(root.val);
            int tmp = leftPos;
            leftPos = rightPos;
            rightPos = tmp;

            TreeNode tmpRoot = root.left;
            root.left = root.right;
            root.right = tmpRoot;

        }

        if (((leftPos != -1) && leftPos < start) || ((rightPos != -1) && rightPos < start))
            return false;

        return process(root.left, map, list, voyage, leftPos, rightPos == -1 ? end : rightPos - 1) && process(root.right, map, list, voyage, rightPos,end);

    }
}
