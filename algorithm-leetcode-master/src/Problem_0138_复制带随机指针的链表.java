import java.util.HashMap;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0138_复制带随机指针的链表 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        Node newHead = null;
        Node curNew = null;
        while (cur != null) {
            if(newHead == null) {
                newHead = map.get(cur);
                curNew = map.get(cur);
            }else{
                curNew.next = map.get(cur);
                curNew = curNew.next;
            }
            curNew.random = map.get(cur.random);
            cur = cur.next;
        }
        return newHead;
    }
}
