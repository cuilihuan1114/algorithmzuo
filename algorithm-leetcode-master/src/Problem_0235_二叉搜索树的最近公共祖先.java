/**
 * Created by CUI on 2021/1/9
 */
public class Problem_0235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       while (root != null){
           if(p.val < root.val && q.val < root.val){
               root = root.left;
           }else if(p.val > root.val && q.val > root.val){
               root = root.right;
           }else
               break;
       }
        return root;
    }
}
