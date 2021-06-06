
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/29 18:06
 */

public class Problem_0958_二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean flag = true;

        while (list.size() != 0){
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (!list.isEmpty()){
                TreeNode treeNode = list.pollFirst();
                if(!flag && (treeNode.left != null || treeNode.right != null))
                    return false;
                if(treeNode.right != null && treeNode.left != null){
                    tmp.addLast(treeNode.left);
                    tmp.addLast(treeNode.right);
                }else if(treeNode.left != null){
                    flag = false;
                    tmp.addLast(treeNode.left);
                }else if(treeNode.right != null){
                    return false;
                }else{
                    flag = false;
                }
            }
            list = tmp;
        }
        return true;
    }
}
