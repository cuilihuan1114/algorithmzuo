import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/21 20:54
 */
public class Problem_0017_电话号码的字母组合 {

    public static void main(String[] args) {
        List<String> list = new Problem_0017_电话号码的字母组合().letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return list;
        char[][] nums = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        process(digits, list, nums, 0,"");
        return list;
    }

    private void process(String digits, List<String> list, char[][] nums, int index,String path) {
        if (index == digits.length()) {
            list.add(path);
            return;
        }
        int pos = digits.charAt(index) - '0';
        for (int i = 0; i < nums[pos - 2].length; i++) {
            process(digits, list, nums, index + 1, path + nums[pos - 2][i]);
        }
    }


}
