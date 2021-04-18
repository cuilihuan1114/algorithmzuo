import java.util.LinkedList;

/**
 * @author cuilihuan
 * @data 2021/3/15 10:09
 */
public class Problem_0481_神奇字符串 {
    public static void main(String[] args) {
        System.out.println(new Problem_0481_神奇字符串().magicalString(6));
    }

    public int magicalString(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int count = 2;
        int sum = 1;

        int cur = 2;
        int pre = 1;
        boolean flag = false;
        while (count < n) {
            if (cur == 2) {
                if (pre == 1) {
                    if (flag) {
                        count++;
                        queue.addLast(2);
                    }
                    count++;
                    queue.addLast(2);
                    flag = true;
                    if (count == n)
                        break;

                } else {
                    count++;
                    sum++;
                    queue.addLast(1);
                    if (count == n)
                        break;
                    count++;
                    sum++;
                    queue.addLast(1);
                    if (count == n)
                        break;
                }
            } else {
                if (pre == 1) {
                    count++;
                    queue.addLast(2);
                    if (count == n)
                        break;
                } else {
                    count++;
                    sum++;
                    queue.addLast(1);
                    if (count == n)
                        break;
                }
            }
            pre = queue.peekLast();
            cur = queue.pollFirst();

        }
        return sum;
    }
}