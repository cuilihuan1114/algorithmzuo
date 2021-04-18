import java.util.HashMap;
import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/3/16 10:23
 */
public class Problem_0488_祖玛游戏 {

    public static void main(String[] args) {

        System.out.println(new Problem_0488_祖玛游戏().findMinStep("RRYGGYYRRYGGYYRR", "GGBBB"));
    }

    public int findMinStep(String board, String hand) {
        if (board.length() == 0)
            return 0;
        if (hand.length() == 0)
            return -1;
        int[] count = new int[26];
        int all = 0;
        for (int i = 0; i < hand.length(); i++) {
            count[hand.charAt(i) - 'A']++;
            all++;
        }
        char[] array = new char[]{'R', 'W', 'B', 'Y', 'G'};
        HashMap<String, Integer> cache = new HashMap<>();
        int ans = process(board, count, array, cache);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //在这里用的缓存 有技术 虽然有两个变量 board count 但是吧 如果board一样的话 count的值也会相等 这个结论是否正确呢？ 所以在这里可以只用一个缓存即可 不需要两个变量作为缓存
    private int process(String board, int[] count, char[] array, HashMap<String, Integer> cache) {
        String hashCode = getHashCode(board, count, array);

        if (cache.containsKey(hashCode))
            return cache.get(hashCode);

        if (isSame(board)) {
            return 0;
        }

        if (board.length() == 0)
            return 0;

        if (isRemain(count)) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < array.length; j++) {
                int cur = array[j] - 'A';
                if (count[cur] > 0) {
                    count[cur]--;
                    StringBuilder sb = new StringBuilder(board);
                    sb.insert(i + 1, array[j]);
                    String res = getStr(board, i, array[j]);
                    int ans = process(res, count, array, cache);
                    min = Math.min(min, ans != Integer.MAX_VALUE ? ans + 1 : Integer.MAX_VALUE);
                    count[cur]++;
                }
            }
        }
        cache.put(hashCode, min);
        return min;
    }

    private String getHashCode(String board, int[] count, char[] array) {
        StringBuilder sb = new StringBuilder(board);
        for (int i = 0; i < array.length; i++) {
            sb.append("_" + array[i] + "_" + count[array[i] - 'A']);
        }
        return sb.toString();
    }

    public String getStr(String s, int idx, char c) {
        int i = idx, j = idx + 1;
        int n1 = 0, n2 = 0, n3 = 1;
        while (i >= 0 && j < s.length()) {
            while (i >= 0 && s.charAt(i) == c) {
                n1++;
                i--;
            }

            while (j < s.length() && s.charAt(j) == c) {
                n2++;
                j++;
            }

            if (n1 + n2 + n3 >= 3) {
                n1 = 0;
                n2 = 0;
                n3 = 0;
                if (i >= 0) {
                    c = s.charAt(i);
                }
            } else {
                break;
            }
        }
        String s1 = "", s2 = "";
        i += n1;
        j -= n2;
        if (i >= 0) {
            s1 = s.substring(0, i + 1);
        }
        if (j < s.length()) {
            s2 = s.substring(j, s.length());
        }

        return n3 == 1 ? s1 + c + s2 : s1 + s2;
    }

    private boolean isRemain(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }


    private boolean isSame(String board) {
        int count = 0;
        for (int i = 0; i < board.length(); i++) {
            if (i != 0 && board.charAt(i) != board.charAt(i - 1))
                return false;
            count++;
        }
        return count >= 3;
    }


    private String getProcess1(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            temp = new Stack<>();
            if (stack.isEmpty() || s.charAt(i) == stack.peek()) {
                stack.push(s.charAt(i));
                i++;
            } else {
                char cur = stack.pop();
                temp.push(cur);
                while (!stack.isEmpty() && cur == stack.peek()) {
                    temp.push(stack.pop());
                }
                if (temp.size() < 3) {
                    while (!temp.isEmpty())
                        stack.push(temp.pop());
                    stack.push(s.charAt(i));
                    i++;
                }
            }
        }
        temp = new Stack<>();
        if (!stack.isEmpty()) {
            char cur = stack.pop();
            temp.push(cur);
            while (!stack.isEmpty() && cur == stack.peek()) {
                temp.push(stack.pop());
            }
            if (temp.size() < 3) {
                while (!temp.isEmpty())
                    stack.push(temp.pop());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }


    private String getProcess(String s) {
        int count = 0;
        int i = 0;
        boolean flag = false;
        for (i = 0; i <= s.length() - 1; i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else if (count >= 3) {
                flag = true;
                break;
            } else
                count = 1;
        }
        flag = flag || (count >= 3);
        if (!flag) return s;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            if (j >= i || j < i - count)
                sb.append(s.charAt(j));
        }
        String ans = sb.toString();
        return getProcess(ans);

    }


}
