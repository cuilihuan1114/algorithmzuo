 /**
     * @author cuilihuan
     * @data 2021/4/11 20:06
     */
    public  class Problem_0725_分隔链表 {

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode[] splitListToParts(ListNode root, int k) {
            int all = 0 ;
            ListNode cur = root;
            while (cur != null){
                all++;
                cur = cur.next;
            }

            int averge = all / k;
            int pre = all % k;
            ListNode[] node = new ListNode[k];

            int count = 0;
            int sum = (pre == 0 ? 0 : 1) + averge;

            pre = pre == 0 ? 0 : pre - 1;

            cur = root;
            int pos = 0;
            node[pos] = root;
            while (cur != null){
                count++;
                if(count == sum){
                    ListNode tmp = cur.next;
                    cur.next = null;
                    cur = tmp;

                    sum = (pre == 0 ? 0 : 1) + averge;
                    pre = pre == 0 ? 0 : pre - 1;

                    count = 0;
                    if(cur != null)
                        node[++pos] = cur;
                }else
                    cur = cur.next;

            }
            return node;
        }
    }