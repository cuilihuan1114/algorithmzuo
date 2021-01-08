import java.util.List;

/**
 * Created by CUI on 2021/1/3
 */
public class Problem_0141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
             if(slow.next== null || fast.next == null || fast.next.next == null)
                 return false;
             slow = slow.next;
             fast = fast.next.next;
        }
        return true;
    }
}
