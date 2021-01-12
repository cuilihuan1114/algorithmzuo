import java.util.ArrayList;
import java.util.List;

/**
 * Created by CUI on 2021/1/8
 */
public class Problem_0230_二叉搜索树中第K小的元素 {
    public int kthSmallest1(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        post1(root, list);
        return list.get(k - 1).val;
    }

    private void post1(TreeNode root, List<TreeNode> list) {
        if(root == null)
            return;
        post1(root.left, list);
        list.add(root);
        post1(root.right, list);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] num = new int[1];
        int[] cur = new int[1];
        post(root, num,k,cur);
        return num[0];
    }

    private void post(TreeNode root, int[] num,int n,int[] cur) {
        if(root == null)
            return;
        post(root.left, num,n,cur);
        cur[0] = cur[0]+1;
        if(cur[0] == n){
            num[0] = root.val;
            return;
        }

        post(root.right, num,n,cur);
    }
}
