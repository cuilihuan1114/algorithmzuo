/**
 * @author cuilihuan
 * @data 2020/11/24 11:00
 */
public class Problem_0024_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;

        ListNode cur = null;
        ListNode mid = null;
        while (pre.next != null && pre.next.next != null) {
            mid = pre.next;
            cur = pre.next.next;

            pre.next = cur;
            mid.next = cur.next;
            cur.next = mid;

            pre = mid;
        }
        return newHead.next;
    }
}
