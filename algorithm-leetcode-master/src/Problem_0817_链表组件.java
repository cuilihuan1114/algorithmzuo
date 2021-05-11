
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/9 10:37
 */
public class Problem_0817_链表组件 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }

        int nums = 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            int num = cur.val;
            if(set.contains(num))
                count++;
            else {
                if(count != 0)
                    nums++;
                count = 0;
            }
            cur = cur.next;
        }
        if(count != 0)
            nums++;
        return nums;
    }
}
