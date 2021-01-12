import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<Integer> cur = new LinkedList<>(); 
        process(root, list,cur);
        return list;
    }

    private void process(TreeNode root, List<String> list, LinkedList<Integer> path) {
        if(root == null){
            return;
        }
        path.addLast(root.val);
        if(root.left == null && root.right == null){
            list.add(pathToString(path));
            path.removeLast();
            return;
        }
        process(root.left, list, path);
        process(root.right, list, path);
        path.removeLast();
    }

    private String pathToString(LinkedList<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if(i != path.size() - 1)
                sb.append(path.get(i)).append("->");
            else
                sb.append(path.get(i));
        }
        return sb.toString();
    }
}
