
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/8 14:27
 */
public class Problem_0805_数组的均值分割 {

    public static void main(String[] args) {
        System.out.println(new Problem_0805_数组的均值分割().splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));

    }


    public boolean splitArraySameAverage1(int[] A) {
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            n = n + A[i];
        }
        boolean[][] flag = new boolean[A.length][n + 1];
        flag[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int k = A.length - 1; k >= 1; k--) {
                for (int j = n; j > 0; j--) {
                    if ((j >= A[i]) && (flag[k - 1][j - A[i]])) {
                        flag[k][j] = true;
                        if (j * A.length == k * n) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }




    public boolean splitArraySameAverage(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int count = 0;
        int curSum = 0;
        Map<String, Boolean> map = new HashMap<>();
        return process(nums, sum, count, curSum, 0, map);
    }

    private boolean process(int[] nums, int sum, int count, int curSum, int index, Map<String, Boolean> map) {
        String code = getCode(index, count, curSum);
        if (map.containsKey(code))
            return map.get(code);

        if (index == nums.length) {
            map.put(code, false);
            return false;
        }

        if ((curSum * (nums.length - count) == (sum - curSum) * count) && (count != 0 && count != nums.length)) {
            map.put(code, true);
            return true;
        }

        if(curSum > sum / 2 && (count < nums.length / 2)){
            map.put(code, false);
            return false;
        }

        boolean flag = process(nums, sum, count, curSum, index + 1, map);
        if (!flag)
            flag = process(nums, sum, count + 1, curSum + nums[index], index + 1, map);

        map.put(code, flag);
        return flag;
    }

    private String getCode(int count, int curSum, int index) {
        return count + "_" + curSum + ":" + index;
    }
}
