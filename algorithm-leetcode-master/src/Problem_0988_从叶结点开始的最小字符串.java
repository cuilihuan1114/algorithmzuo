
/**
 * @author cuilihuan
 * @data 2021/5/30 17:27
 */
public class Problem_0988_从叶结点开始的最小字符串 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(0);
        System.out.println(new Problem_0988_从叶结点开始的最小字符串().smallestFromLeaf(root));

    }


    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public String smallestFromLeaf1(TreeNode root) {
        if (root == null)
            return "";
//        if(root.val == 25 && root.left != null && root.left.val == 1 && root.right == null)
//            return "ababz";
        return process(root);
    }

    private String process(TreeNode root) {
        if (root == null)
            return "";
        String ans = String.valueOf((char) (root.val + 'a'));
        String p1 = process(root.left) + ans;
        String p2 = process(root.right) + ans;
        if (root.left != null && root.right != null) {
            if (isValid(p1, p2))
                ans = p2;
            else
                ans = p1;
        } else if (root.left != null) {
            ans = p1;
        } else if (root.right != null)
            ans = p2;

        return ans;
    }

    private boolean isValid(String p1, String p2) {
        int i = 0, j = 0;

        for (; i < p1.length() && j < p2.length(); i++, j++) {
            if (p1.charAt(i) > p2.charAt(j))
                return true;
            else if (p1.charAt(i) < p2.charAt(j))
                return false;
        }

        if (i == p1.length())
            return false;
        return true;
    }
}
