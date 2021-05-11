
/**
 * @author cuilihuan
 * @data 2021/5/10 9:36
 */
public class Problem_0838_推多米诺 {

    public static void main(String[] args) {
        System.out.println(new Problem_0838_推多米诺().pushDominoes("R...R"));
    }


    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0)
            return "";
        char pre = '.';
        char[] array = dominoes.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char cur = array[i];
            if (cur == 'L' || cur == 'R') {
                pre = cur;
                continue;
            }

            int end = i + 1;
            while (end < array.length) {
                if (array[end] != '.')
                    break;
                end++;
            }
            process(array, i, end, pre);
            i = end - 1;
        }

        return String.valueOf(array);

    }

    private void process(char[] array, int start, int end, char pre) {
        char left = pre;
        char right = (end == array.length ? '.' : array[end]);
        end = end - 1;
        boolean flag = false;
        while (start < end) {
            flag = false;
            if (left == 'R') {
                array[start] = 'R';
                start++;
                flag = true;
            } else
                left = '.';

            if (right == 'L') {
                array[end] = 'L';
                end--;
                flag = true;
            } else
                right = '.';

            if (!flag)
                break;
        }

        if (start == end) {
            if (left == 'R' && right == 'L')
                array[start] = '.';
            else if (left == 'R')
                array[start] = 'R';
            else if (right == 'L')
                array[start] = 'L';

        }
    }
}
