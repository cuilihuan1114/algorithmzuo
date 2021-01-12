/**
 * Created by CUI on 2021/1/9
 */
public class Problem_0234_回文链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(-1);
        head.next.next.next = new ListNode(-1);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(1);
        boolean palindrome = new Problem_0234_回文链表().isPalindrome(head);
        System.out.println(palindrome);
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 1->2
        ListNode left = head.next;
        ListNode right = head.next;
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }

        ListNode cur = left;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }
        right = pre;

        boolean flag = true;
        left = head;
        while (pre != null) {
            if (pre.val != left.val) {
                flag = false;
                break;
            }
            pre = pre.next;
            left = left.next;
        }

        pre = null;
        while (right != null) {
            ListNode tmp = right;
            right = right.next;
            tmp.next = pre;
            pre = tmp;
        }

        return flag;


    }
}
