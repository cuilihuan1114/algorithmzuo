import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/21 17:04
 */
public class Problem_0022_括号生成 {
    public static void main(String[] args) {
        List<String> list = new Problem_0022_括号生成().generateParenthesis(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[n * 2];
        process1(list, chars, 0, 0, 0);
        return list;
    }

    private void process1(List<String> list, char[] chars, int index, int leftRest, int rest) {
        if (index == chars.length) {
            list.add(String.valueOf(chars));
            return;
        }

        if (leftRest > 0) {
            chars[index] = ')';
            process1(list, chars, index + 1, leftRest - 1, rest);
        }
        //注意想清楚有没有=号
        if (rest < chars.length / 2) {
            chars[index] = '(';
            //注意是++rest 而不是rest++
            process1(list, chars, index + 1, leftRest + 1, ++rest);
        }

    }


    //完全暴力 不剪枝
    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[n * 2];
        process(list, chars, 0);
        return list;
    }

    private void process(List<String> list, char[] chars, int index) {
        if (index == chars.length) {
            if (isValid(chars))
                list.add(String.valueOf(chars));
            return;
        }
        chars[index] = '(';
        process(list, chars, index + 1);
        chars[index] = ')';
        process(list, chars, index + 1);

    }

    private boolean isValid(char[] chars) {
        int n = chars.length / 2;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (left < 0 || left > n)
                return false;
            if (chars[i] == '(')
                left++;
            else
                left--;

        }
        return left == 0;
    }
}
