/**
 * Created by CUI on 2021/1/12
 */
public class Problem_0328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode odd = null;
        ListNode even = null;
        ListNode evenHead = null;
        boolean flag = true;
        while (cur != null) {
            if (flag) {
                if (odd == null) {
                    odd = cur;
                } else {
                    odd.next = cur;
                    odd = odd.next;
                }
            }else {
                if (even == null) {
                    even = cur;
                    evenHead = cur;
                } else {
                    even.next = cur;
                    even = even.next;
                }
            }
            cur = cur.next;
            flag = !flag;
        }
        even.next = null;
        odd.next = evenHead;
        return head;

    }
}
