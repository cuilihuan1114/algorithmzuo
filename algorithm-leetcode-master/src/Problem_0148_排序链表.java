/**
 * Created by CUI on 2021/1/4
 */
public class Problem_0148_排序链表 {

    //递归版本
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //注意这里
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }




    //此题要求是用常数级别的空间复杂度
    public ListNode sortList1(ListNode head) {
        if (head == null)
            return head;
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        for (int len = 1; len < N; len <<= 1) {
            cur = head;
            ListNode pre = null;
            while (cur != null) {
                int count = 0;
                ListNode ls = null;
                ListNode le = null;
                ListNode rs = null;
                ListNode re = null;
                while (cur != null) {
                    count++;
                    if (count == 1) {
                        ls = cur;
                    }
                    if (count <= len)
                        le = cur;
                    if (count == len + 1) {
                        rs = cur;
                    }
                    if (count > len)
                        re = cur;
                    cur = cur.next;
                    if (count == 2 * len)
                        break;
                }
                ListNode[] mergeNode = merge(ls, le, rs, re);
                if (pre == null) {
                    head = mergeNode[0];
                } else {
                    pre.next = mergeNode[0];
                }
                pre = mergeNode[1];
            }
        }
        return head;
    }

    private ListNode[] merge(ListNode ls, ListNode le, ListNode rs, ListNode re) {
        if (rs == null)
            return new ListNode[]{ls, le};
        ListNode cur = null;
        ListNode head = null;
        ListNode pre = null;
        ListNode tail = null;

        while (ls != le.next && rs != re.next) {
            if (ls.val > rs.val) {
                cur = rs;
                rs = rs.next;
            } else {
                cur = ls;
                ls = ls.next;
            }

            if (head == null) {
                head = cur;
                pre = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }

        // 在这里必须用If else来判断一下
        // 不能直接并行执行
        if (ls != le.next) {
            while (ls != le.next) {
                pre.next = ls;
                ls = ls.next;
                pre = pre.next;
            }
        } else {
            while (rs != re.next) {
                pre.next = rs;
                rs = rs.next;
                pre = pre.next;
            }
        }

        tail = pre;
        pre.next = null;
        return new ListNode[]{head, tail};
    }
}
