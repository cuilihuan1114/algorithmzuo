
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/11 19:58
 */


public class Problem_0865_具有所有最深节点的最小子树 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        else {
            int ldep = maxDepth(root.left), rdep = maxDepth(root.right);
            if (ldep == rdep)
                return root;
            else if (ldep > rdep)
                return subtreeWithAllDeepest(root.left);
            else
                return subtreeWithAllDeepest(root.right);
        }
    }

    int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
