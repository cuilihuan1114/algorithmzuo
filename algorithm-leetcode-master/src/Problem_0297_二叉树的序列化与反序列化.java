import java.awt.*;
import java.util.LinkedList;

/**
 * Created by CUI on 2021/1/11
 */
public class Problem_0297_二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Problem_0297_二叉树的序列化与反序列化 test = new Problem_0297_二叉树的序列化与反序列化();
//        System.out.println(test.serialize(root));
        String s = "[]".substring(1, "[]".length() - 1);
        System.out.println(s.split(",").length);
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<String> ans = new LinkedList<>();
        if (root != null) {
            ans.addLast(String.valueOf(root.val));
            list.addLast(root);
        }

        while (!list.isEmpty()) {
            TreeNode cur = list.pop();
            if (cur.left != null) {
                ans.addLast(String.valueOf(cur.left.val));
                list.addLast(cur.left);
            } else {
                ans.addLast("null");
            }

            if (cur.right != null) {
                list.addLast(cur.right);
                ans.addLast(String.valueOf(cur.right.val));
            } else
                ans.addLast("null");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!ans.isEmpty()) {
            sb.append(ans.pop());
            sb.append(",");
        }

        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setCharAt(sb.length() - 1, ']');
        } else
            sb.append("]");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String s = data.substring(1, data.length() - 1);
        if(s.length() == 0)
            return null;
        String[] split = s.split(",");
        if (split.length == 0)
            return null;
        if (split[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        TreeNode cur = root;
        LinkedList<TreeNode> ans = new LinkedList<>();
        ans.addLast(root);
        int index = 1;
        while (!ans.isEmpty()) {
            cur = ans.pop();
            if(!split[index].equals("null")){
                cur.left = new TreeNode(Integer.valueOf(split[index]));
                ans.addLast(cur.left);
            }
            index++;
            if(!split[index].equals("null")){
                cur.right = new TreeNode(Integer.valueOf(split[index]));
                ans.addLast(cur.right);
            }
            index++;
        }

        return root;
    }
}
