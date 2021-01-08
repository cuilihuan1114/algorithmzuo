/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = cur;
        while (cur != null) {
            if(cur.val == val){
                if(cur == head){
                    cur = cur.next;
                    head = cur;
                    continue;
                }else{
                    pre.next = cur.next;
                }
            }else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
