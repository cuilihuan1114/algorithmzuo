
/**
 * @author cuilihuan
 * @data 2021/6/1 17:14
 */
public class Problem_0985_查询后的偶数和 {
    public static void main(String[] args) {
        System.out.println(new Problem_0985_查询后的偶数和().sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
                {1, 0}, {-3, 1}, {-4, 0}, {2, 3}}));

    }
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        if(nums == null || nums.length == 0)
            return nums;
        int sum  = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0)
                sum += nums[i];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < queries.length; i++) {
            int var = queries[i][0];
            int index = queries[i][1];
            int res = nums[index] + var;
            sum += -(nums[index] % 2 == 0 ? nums[index] : 0) + (res % 2 == 0 ? res : 0);
            nums[index] = res;
            ans[i] = sum;
        }

        return ans;
    }
}
