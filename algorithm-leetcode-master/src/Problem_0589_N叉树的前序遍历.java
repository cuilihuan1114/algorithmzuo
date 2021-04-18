import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/21 16:40
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Problem_0589_N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private void process(Node root, List<Integer> list) {
       if(root == null)
           return;
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            Node cur = root.children.get(i);
            process(cur, list);
        }
    }
}
