import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/21 16:22
 */


public class Problem_0559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        boolean flag = true;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i)));
        }
        max = max + 1;
        return max;
    }
}
