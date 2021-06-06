
import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/5/29 9:57
 */
public class Problem_0946_验证栈序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length == 0)
            return true;

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < popped.length && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
