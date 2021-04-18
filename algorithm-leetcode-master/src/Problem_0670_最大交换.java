import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/4/4 17:59
 */
public class Problem_0670_最大交换 {

    public static void main(String[] args) {
        System.out.println(new Problem_0670_最大交换().maximumSwap(43456));
    }

    public int maximumSwap(int num) {
        if (num == 0)
            return 0;
        char[] chars = String.valueOf(num).toCharArray();
        Stack<Integer> stack = new Stack<>();
        int pre = chars.length;

        int cur = -1;
        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && chars[stack.peek()] < chars[i]) {
                int pop = stack.pop();
                if (pre > pop) {
                    pre = pop;
                    cur = i;
                }
            }
            stack.push(i);
        }

        if (pre == chars.length)
            return num;

        for (int i = cur + 1; i < chars.length; i++) {
            if (chars[cur] <= chars[i])
                cur = i;
        }

        char temp = chars[pre];
        chars[pre] = chars[cur];
        chars[cur] = temp;

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }

        return res;
    }
}