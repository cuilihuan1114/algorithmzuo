import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/8 21:50
 */
public class Problem_0429_N叉树的层序遍历 {

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null)
            return list;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node preLast = root;
        Node node = null;
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            while (preLast != node){
                node = queue.pop();
                cur.add(node.val);
                for(Node child : node.children){
                    queue.addLast(child);
                }
            }
            list.add(cur);
            preLast = queue.peekLast();
        }
        return list;
    }
}
