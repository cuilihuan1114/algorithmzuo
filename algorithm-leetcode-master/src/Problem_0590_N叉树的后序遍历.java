import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/21 16:45
 */
public class Problem_0590_N叉树的后序遍历 {


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    private void process(Node root, List<Integer> list) {
        if(root == null)
            return;
        for (int i = 0; i < root.children.size(); i++) {
            Node cur = root.children.get(i);
            process(cur, list);
        }
        list.add(root.val);
    }
}
