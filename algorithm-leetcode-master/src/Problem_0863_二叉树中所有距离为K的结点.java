
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/11 18:25
 */


public class Problem_0863_二叉树中所有距离为K的结点 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new Problem_0863_二叉树中所有距离为K的结点().distanceK(root, root.left, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null || target == null)
            return list;




        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);
        Set<TreeNode> set = new HashSet<>();
        process(target, k, 0, list,target, set);

        int cur = 0;
        TreeNode parent = target;


        set.add(target);

        while (cur < k) {
            if(!map.containsKey(parent))
                break;
            parent = map.get(parent);
            cur++;
            process(parent, k, cur, list,target,set);
        }

        return list;


    }

    private void process(TreeNode root, int k, int count, List<Integer> list, TreeNode target, Set<TreeNode> set) {
        if (root == null)
            return;

        if(set.contains(root))
            return;

        set.add(root);
        if (k == count) {
            list.add(root.val);
            return;
        }


        process(root.left, k, count + 1, list,target, set);
        process(root.right, k, count + 1, list,target, set);
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null)
            return;

        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left, map);
        }

        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right, map);
        }
    }
}
