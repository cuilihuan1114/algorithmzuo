import java.util.Currency;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            n++;
            curA = curA.next;
        }
        while (curB != null) {
            n--;
            curB = curB.next;
        }
        ListNode cur = n > 0 ? headA : headB;
        ListNode curOther = n > 0 ? headB : headA;
        n = Math.abs(n);
        // 3 a->b->c->d->e
        while (n > 0) {
            cur = cur.next;
            n--;
        }
        while (cur != curOther) {
            cur = cur.next;
            curOther = curOther.next;
        }
        return cur;
    }
}
