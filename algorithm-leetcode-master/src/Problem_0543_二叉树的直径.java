/**
 * Created by CUI on 2021/2/24
 */
public class Problem_0543_二叉树的直径 {

    class Info{
        int maxPath;
        int maxStraight;

        public Info(int maxStraight, int maxPath) {
            this.maxPath = maxPath;
            this.maxStraight = maxStraight;
        }
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        return process(root).maxPath;
    }

    private Info process(TreeNode root) {
        if(root == null)
            return new Info(0,0);
        Info left = process(root.left);
        Info right = process(root.right);
        int maxStraight = Math.max(left.maxStraight, right.maxStraight) + 1;
        int curmaxPath = left.maxStraight + right.maxStraight + 1;
        int maxPath = Math.max(curmaxPath, Math.max(left.maxPath, right.maxPath));
        return new Info(maxStraight,maxPath);
    }
}
