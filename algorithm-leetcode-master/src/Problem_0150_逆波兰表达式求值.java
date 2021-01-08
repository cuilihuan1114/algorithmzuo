import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> queue = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int other = queue.pop();
                int one = queue.pop();
                switch (tokens[i]) {
                    case "+":
                        queue.add(one + other);
                        break;
                    case "-":
                        queue.add(one - other);
                        break;
                    case "*":
                        queue.add(one * other);
                        break;
                    case "/":
                        queue.add(one / other);
                        break;
                }
            } else {
                queue.add(Integer.valueOf(tokens[i]));
            }
        }
        return queue.pop();
    }
}
