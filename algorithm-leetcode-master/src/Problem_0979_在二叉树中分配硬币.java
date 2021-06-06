

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/30 16:55
 */



public class Problem_0979_在二叉树中分配硬币 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(new Problem_0979_在二叉树中分配硬币().distributeCoins(root));
    }

    private int ans = 0;// 移动次数
    public int distributeCoins(TreeNode root) {
        lrd(root);
        return ans;
    }
    public int lrd(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null){
            root.val += lrd(root.left);
        }
        if(root.right != null){
            root.val += lrd(root.right);
        }
        ans += Math.abs(root.val - 1);
        return root.val - 1;
    }
}
