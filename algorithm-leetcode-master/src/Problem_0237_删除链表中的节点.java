/**
 * Created by CUI on 2021/1/9
 */
public class Problem_0237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        if(node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
