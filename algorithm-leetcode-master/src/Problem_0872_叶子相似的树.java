
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/24 9:45
 */


public class Problem_0872_叶子相似的树 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeaf(root1, list1);
        getLeaf(root2, list2);

        if(list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            int nums = list1.get(i);
            if(nums != list2.get(i))
                return false;
        }
        return true;
    }

    private void getLeaf(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }

        getLeaf(root.left,list);
        getLeaf(root.right, list);
    }
}
