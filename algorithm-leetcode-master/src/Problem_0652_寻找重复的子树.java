import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/26 9:44
 */



public class Problem_0652_寻找重复的子树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(new Problem_0652_寻找重复的子树().findDuplicateSubtrees(root).size());
    }

    // 将方法进行序列化处理 需要前序遍历 生成唯一的序列
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<String,Integer> map  = new HashMap<>();
        HashMap<TreeNode, String> cache = new HashMap<>();
        process(root, list, map,cache);
        return list;
    }

    private String process(TreeNode root, List<TreeNode> list, HashMap<String,Integer> map,HashMap<TreeNode,String> cache) {
        if (root == null)
            return "_";
        if(cache.containsKey(root))
            return cache.get(root);
        String ans = root.val + "#" + process(root.left, list, map,cache) + "#" + process(root.right, list, map,cache);
        if(map.containsKey(ans)){
            map.put(ans, map.get(ans) + 1);
            if(map.get(ans) == 2)
                list.add(root);
        }else
            map.put(ans, 1);
        cache.put(root, ans);
        return ans;



    }

    // 下面这个方法会超出时间限制的
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        process(root, root, list, set);
        return list;
    }

    private void process(TreeNode target, TreeNode cur, List<TreeNode> list, HashSet<String> set) {
        if (cur == null)
            return;

        if (haveSame(target, cur)) {
            String code = getCode(cur);
            if (!set.contains(code)) {
                list.add(cur);
                set.add(code);
            }
        }
        process(target, cur.left, list, set);
        process(target, cur.right, list, set);
    }

    private String getCode(TreeNode cur) {
        if (cur == null)
            return "_";
        String ans = cur.val + "_";
        ans += getCode(cur.left);
        ans += getCode(cur.right);
        return ans;
    }

    private boolean haveSame(TreeNode target, TreeNode cur) {
        if (target == null)
            return false;
        if (isSame(target, cur))
            return true;
        return haveSame(target.left, cur) || haveSame(target.right, cur);
    }

    private boolean isSame(TreeNode target, TreeNode cur) {
        if (target == null && cur == null)
            return true;
        if (target == null || cur == null)
            return false;
        if (target == cur)
            return false;
        if (target.val != cur.val)
            return false;
        return isSame(target.left, cur.left) && isSame(target.right, cur.right);
    }
}
