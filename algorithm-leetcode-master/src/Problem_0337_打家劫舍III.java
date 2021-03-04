/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0337_打家劫舍III {

    class Info{
        int no;
        int yes;

        public Info() {
        }

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public int rob(TreeNode root) {
        Info info = process(root);
        return Math.max(info.no, info.yes);
    }

    private Info process(TreeNode root) {
        if(root == null)
            return new Info(0, 0);
        Info left = process(root.left);
        Info right = process(root.right);

        int no = left.yes + right.yes;
        int yes = Math.max(left.no + right.no + root.val,no);

        return new Info(no, yes);

    }
}
