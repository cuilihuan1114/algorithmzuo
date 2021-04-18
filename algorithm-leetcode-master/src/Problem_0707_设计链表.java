/**
 * @author cuilihuan
 * @data 2021/4/11 15:09
 */
public class Problem_0707_设计链表 {


    public static void main(String[] args) {
        Problem_0707_设计链表 test = new Problem_0707_设计链表();
        test.addAtHead(0);
        test.addAtIndex(1, 4);
        test.addAtTail(8);
        test.addAtHead(5);

        test.addAtIndex(4, 3);
        test.addAtTail(0);
        test.addAtTail(5);
        test.addAtIndex(6, 3);
        test.deleteAtIndex(7);
        test.deleteAtIndex(5);
        test.addAtTail(4);
        test.deleteAtIndex(1);
    }

    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    Node root = new Node();
    Node tail = root;
    int count = -1;


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > count)
            return -1;
        int num = -1;
        Node cur = root;
        while (num != index) {
            cur = cur.next;
            num++;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node add = new Node(val);
        Node temp = root.next;
        root.next = add;
        add.next = temp;
        if (tail == root)
            tail = add;
        count++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node add = new Node(val);
        tail.next = add;
        tail = add;
        count++;

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == count + 1) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else if (index < count + 1) {
            int sum = -1;
            Node cur = root;
            while (sum < index - 1) {
                cur = cur.next;
                sum++;
            }
            Node temp = cur.next;
            Node node = new Node(val);
            cur.next = node;
            node.next = temp;
            count++;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < count + 1 && index >= 0) {
            int sum = -1;
            Node cur = root;
            while (sum < index - 1) {
                cur = cur.next;
                sum++;
            }
            cur.next = cur.next.next;
            if (index == count)
                tail = cur;
            count--;
        }
    }
}