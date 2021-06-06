
/**
 * @author cuilihuan
 * @data 2021/5/28 9:35
 */
public class Problem_0915_分割数组 {

    public static void main(String[] args) {
        System.out.println(new Problem_0915_分割数组().partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(System.currentTimeMillis());
    }

    public int partitionDisjoint(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = Math.max(nums[i], i > 0 ? left[i - 1] : 0);
        }

        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            right[i] = Math.min(nums[i], i == nums.length - 1 ? Integer.MAX_VALUE : right[i + 1]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if(left[i] <= right[i+1])
                return i + 1;
        }
        return -1;
    }
}
