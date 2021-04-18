import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/3/17 8:44
 */
public class Problem_0482_密钥格式化 {
    public String licenseKeyFormatting(String S, int K) {
        if(S == null || S.length() == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '-')
                continue;
            stack.push(S.charAt(i));
        }

        while (!stack.isEmpty()){
            char pop = stack.pop();
            count++;
            sb.append(toUpper(pop));
            if(count == K && !stack.isEmpty()){
                sb.append("-");
                count = 0;
            }
        }

        return sb.reverse().toString();

    }

    private char toUpper(char pop) {
        if(pop >= 'a' && pop <= 'z')
            return (char)(pop - 'a' + 'A');
        return pop;
    }
}
