import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/4/13 14:29
 */
public class Problem_0784_字母大小写全排列 {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();

        if (S == null || S.length() == 0)
            return list;
        char[] array = S.toCharArray();

        process(array, list, 0);
        return list;
    }

    private void process(char[] array, List<String> list, int index) {
        if (index == array.length) {
            list.add(String.valueOf(array));
            return;
        }

        char cur = array[index];
        process(array, list, index + 1);

        if (cur >= 'a' && cur <= 'z') {
            array[index] = (char) (array[index] - 'a' + 'A');
            process(array, list, index + 1);
        } else if (cur >= 'A' && cur <= 'Z') {
            array[index] = (char) (array[index] - 'A' + 'a');
            process(array, list, index + 1);
        }
    }
}