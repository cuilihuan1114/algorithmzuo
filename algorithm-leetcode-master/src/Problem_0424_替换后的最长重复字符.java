import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/11 16:27
 */
public class Problem_0424_替换后的最长重复字符 {

    public static void main(String[] args) {
        System.out.println(new Problem_0424_替换后的最长重复字符().characterReplacement("AABABBA",
                1));
    }

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        char[] array = s.toCharArray();

        int[] nums = new int[26];
        int maxNum = 0;


        int left = 0;
        int right = 0;
        int max = 0;
        while (right < array.length) {
            while (right - left <= maxNum + k && right < array.length) {
                nums[array[right] - 'A']++;
                maxNum = Math.max(maxNum, nums[array[right] - 'A']);
                right++;
            }

            max = (right - left <= maxNum + k) ? Math.max(max, right - left) : Math.max(max, right - left - 1);

            nums[array[left] - 'A']--;
            maxNum = calculMax(nums);
            left++;
        }

        return max;

    }

    private int calculMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
