/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0206_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        while (head != null) {
            ListNode tem = head.next;
            head.next = cur;
            cur = head;
            head = tem;
        }
        return cur;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode p = reverseList1(head.next);
        temp.next = head;
        head.next = null;
        return p;
    }


}
