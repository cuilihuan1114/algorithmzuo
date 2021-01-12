import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by CUI on 2021/1/8
 */
public class Problem_0227_基本计算器II {

    public static void main(String[] args) {
        System.out.println(new Problem_0227_基本计算器II().calculate("2"));
    }

    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        LinkedList<String> stack = new LinkedList<>();
        int sum = 0;
        int pre = sum;
        boolean flag = false;
        char op = '/';
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                continue;
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sum = sum * 10 + s.charAt(i) - '0';
            }else{
                if(flag){
                    sum = op == '/' ? (pre / sum) : (pre * sum);
                    flag = false;
                }
                if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                    pre = sum;
                    flag = true;
                    op = s.charAt(i);
                }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                    stack.addLast(String.valueOf(sum));
                    stack.addLast(String.valueOf(s.charAt(i)));
                }
                sum = 0;
            }
        }
        if(flag){
            sum = op == '/' ? (pre / sum) : (pre * sum);
        }
        stack.addLast(String.valueOf(sum));
        if(stack.isEmpty())
            return 0;
        sum = Integer.valueOf(stack.pollFirst());
        while (!stack.isEmpty()){
            String o = stack.pollFirst();
            int num = Integer.valueOf(stack.pollFirst());
            if (o.equals("+")) {
                sum += num;
            } else if (o.equals("-")) {
                sum -= num;
            }
        }
        return sum;
    }
}
