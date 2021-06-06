
/**
 * @author cuilihuan
 * @data 2021/5/26 16:51
 */




public class Problem_0876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null){
            second = second.next;
            second = second.next;
            first = first.next;
        }



        return first;

    }
}
