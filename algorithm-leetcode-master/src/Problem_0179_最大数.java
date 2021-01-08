import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0179_最大数 {
    class MyCompartor implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {
            return -(o1 + o2).compareTo(o2 + o1);
        }
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        //核心点 排序
        Arrays.sort(strs, new MyCompartor());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        return (sb.length()>0 && sb.charAt(0) != '0') ? sb.toString() : "0";

    }
}
