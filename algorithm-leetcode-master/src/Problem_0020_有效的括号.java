import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2020/11/21 20:12
 */
public class Problem_0020_有效的括号 {

    public static void main(String[] args) {
        System.out.println(new Problem_0020_有效的括号().isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int index = 0;
        while (index < s.length()) {
            if(s.charAt(index) == ')'){
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            }else if(s.charAt(index) == '}'){
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }else if(s.charAt(index) == ']'){
                if (stack.isEmpty()  || stack.pop() != '[') {
                    return false;
                }
            }else
                stack.push(s.charAt(index));
            index++;
        }
        return stack.isEmpty();
    }


}
