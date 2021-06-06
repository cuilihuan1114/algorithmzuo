
import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/5/27 16:20
 */
public class Problem_0921_使括号有效的最少添加 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')'){
                if(stack.size() != 0)
                    stack.pop();
                else
                    count++;
            }
        }

        while (!stack.isEmpty()) {
            count++;
            stack.pop();
        }

        return count;
    }
}
