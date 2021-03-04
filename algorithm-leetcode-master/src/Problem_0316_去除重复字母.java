import javafx.scene.CacheHint;

import java.util.Stack;

/**
 * Created by CUI on 2021/3/2
 */
public class Problem_0316_去除重复字母 {


    public static void main(String[] args) {
        new Problem_0316_去除重复字母().removeDuplicateLetters("abacb");
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] vis = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() > s.charAt(i) && count[stack.peek() - 'a'] >= 1 && !vis[s.charAt(i) - 'a']) {
                    vis[stack.pop() - 'a'] = false;
                } else
                    break;
            }
            if (!vis[s.charAt(i) - 'a']) {
                stack.push(s.charAt(i));
                vis[s.charAt(i) - 'a'] = true;
            }
            count[s.charAt(i) - 'a']--;
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }
}
