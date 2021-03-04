import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by CUI on 2021/2/28
 */
public class Problem_0301_删除无效的括号 {


    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int leftRemove = 0;
        int rightRevove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRemove++;
            } else if (s.charAt(i) == ')') {
                if (leftRemove > 0)
                    leftRemove--;
                else
                    rightRevove++;
            }
        }

        char[] array = s.toCharArray();
        StringBuffer cur = new StringBuffer();
        process(array, 0, res, cur, set, leftRemove, rightRevove);
        return res;
    }

    private void process(char[] array, int index, List<String> res, StringBuffer cur, HashSet<String> set, int leftRemove, int rightRevove) {
        if (index == array.length) {
            if (leftRemove == 0 && rightRevove == 0 && isValid(cur) && !set.contains(cur.toString())) {
                res.add(cur.toString());
                set.add(cur.toString());
            }
            return;
        }

        if (leftRemove < 0 || rightRevove < 0)
            return;

        if (array[index] == ')' && rightRevove > 0) {
            process(array, index + 1, res, cur, set, leftRemove, rightRevove-1);
        } else if (array[index] == '(' && leftRemove > 0) {
            process(array, index + 1, res, cur, set, leftRemove-1, rightRevove);
        }

        cur.append(array[index]);
        process(array, index + 1, res, cur, set, leftRemove, rightRevove);
        cur.deleteCharAt(cur.length() - 1);

    }


    //方法2  还是没有充分的利用左右括号匹配的性质 没有对其进行充分的剪枝
    public List<String> removeInvalidParentheses2(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int leftRemove = 0;
        int rightRevove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRemove++;
            } else if (s.charAt(i) == ')') {
                if (leftRemove > 0)
                    leftRemove--;
                else
                    rightRevove++;
            }
        }

        char[] array = s.toCharArray();
        StringBuffer cur = new StringBuffer();
        process2(array, 0, res, cur, set, leftRemove, rightRevove);
        return res;
    }

    private void process2(char[] array, int index, List<String> res, StringBuffer cur, HashSet<String> set, int leftRemove, int rightRevove) {
        if (index == array.length) {
            if (leftRemove == 0 && rightRevove == 0 && isValid(cur) && !set.contains(cur.toString())) {
                res.add(cur.toString());
                set.add(cur.toString());
            }
            return;
        }

        if (leftRemove < 0 || rightRevove < 0)
            return;

        if (array[index] == ')') {
            rightRevove--;
            process2(array, index + 1, res, cur, set, leftRemove, rightRevove);
            rightRevove++;
            cur.append(array[index]);
            process2(array, index + 1, res, cur, set, leftRemove, rightRevove);
            cur.deleteCharAt(cur.length() - 1);

        } else if (array[index] == '(') {
            leftRemove--;
            process2(array, index + 1, res, cur, set, leftRemove, rightRevove);
            leftRemove++;
            cur.append(array[index]);
            process2(array, index + 1, res, cur, set, leftRemove, rightRevove);
            cur.deleteCharAt(cur.length() - 1);
        } else {
            cur.append(array[index]);
            process2(array, index + 1, res, cur, set, leftRemove, rightRevove);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    //方法1当中只能通过123个测试用例 因为没有对深度遍历的方法进行充分的剪枝 看了题解以后 我们来进行充分的剪枝
    public List<String> removeInvalidParentheses1(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        char[] array = s.toCharArray();
        StringBuffer cur = new StringBuffer();
        process1(array, 0, res, cur, set);
        return res;
    }

    private void process1(char[] array, int index, List<String> res, StringBuffer cur, HashSet<String> set) {
        if (index == array.length) {
            if (isValid(cur)) {
                if (res.size() > 0) {
                    if (res.get(0).length() < cur.length()) {
                        res.clear();
                        set.clear();
                        res.add(cur.toString());
                        set.add(cur.toString());
                    } else if (res.get(0).length() == cur.length() && !set.contains(cur.toString())) {
                        res.add(cur.toString());
                        set.add(cur.toString());
                    }
                } else {
                    res.add(cur.toString());
                    set.add(cur.toString());
                }
            }
            return;
        }

        if (array[index] == ')' || array[index] == '(') {
            process1(array, index + 1, res, cur, set);
        }
        cur.append(array[index]);
        process1(array, index + 1, res, cur, set);
        cur.deleteCharAt(cur.length() - 1);
    }

    private boolean isValid(StringBuffer cur) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else
                    stack.push(')');
            } else if (cur.charAt(i) == '(') {
                stack.push('(');
            }
        }
        return stack.isEmpty();
    }
}
