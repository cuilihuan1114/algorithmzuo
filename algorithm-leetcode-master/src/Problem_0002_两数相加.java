/**
 * @author cuilihuan
 * @data 2020/11/20 10:43
 */
public class Problem_0002_两数相加 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int yu  = 0;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int x1 = l1 == null ? 0 : l1.val;
            int x2 = l2 == null ? 0 : l2.val;
            cur.next = new ListNode((x1 + x2 + yu) % 10);
            yu = (x1 + x2 + yu) / 10;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(yu == 1)
            cur.next = new ListNode(1);
        return head.next;
    }
}
