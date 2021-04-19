package D0410;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/11 11:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String s = input.next();

        List<String> all = new LinkedList<>();
        List<String> pre = new LinkedList<>();
        process(s, 0, all, pre);
        int count = 0;
        for (int i = 0; i < all.size(); i++) {
            if (isAbs(all.get(i)))
                count++;

        }
        System.out.println(count);
    }

    private static void process(String s, int index, List<String> all, List<String> pre) {
        if (index == s.length()) {
            return;
        }

        char cur = s.charAt(index);
        for (int i = 0; i < pre.size(); i++) {
            pre.set(i, pre.get(i) + cur);
        }
        pre.add(cur + "");
        all.addAll(pre);
        process(s, index + 1, all, pre);

    }

    private static boolean isAbs(String sb) {
        int[] count = new int[26];
        int K = sb.length() / 2;
        for (int i = 0; i < sb.length(); i++) {
            count[sb.charAt(i) - 'a']++;
            if (count[sb.charAt(i) - 'a'] > K)
                return true;
        }
        return false;
    }
}
