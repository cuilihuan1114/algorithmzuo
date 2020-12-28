import java.util.LinkedList;

/**
 * @author cuilihuan
 * @data 2020/12/20 16:07
 */
public class Problem_0117_填充每个节点的下一个右侧节点指针II {
    public Problem_0116_填充每个节点的下一个右侧节点指针.Node connect(Problem_0116_填充每个节点的下一个右侧节点指针.Node root) {
        if (root == null)
            return null;
        LinkedList<Problem_0116_填充每个节点的下一个右侧节点指针.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Problem_0116_填充每个节点的下一个右侧节点指针.Node pre = null;
            for (int i = 0; i < size; i++) {
                Problem_0116_填充每个节点的下一个右侧节点指针.Node cur = queue.pop();
                if (i != 0) {
                    pre.next = cur;
                    pre = cur;
                } else
                    pre = cur;
                if (cur.left != null)
                    queue.addLast(cur.left);
                if (cur.right != null)
                    queue.addLast(cur.right);
            }
        }
        return root;
    }
}
