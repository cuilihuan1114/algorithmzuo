import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2020/11/24 21:57
 */
public class Problem_0032_最长有效括号 {

    public static void main(String[] args) {
        System.out.println(new Problem_0032_最长有效括号().longestValidParentheses(")()())()()("));
    }

    //栈法
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }


    //动态规划法
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (dp[i-1] > 0 && i - dp[i-1] -1>=0) {
                    dp[i] =  (s.charAt(i - dp[i - 1] - 1) == '(' ? (dp[i-1]+2 + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0)) : 0);
                }
                max = Math.max(max, dp[i]);
            }

        }
        return max;

    }


}
