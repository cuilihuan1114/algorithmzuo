/**
 * @author cuilihuan
 * @data 2021/3/15 9:50
 */
public class Problem_0477_汉明距离总和 {


    //时间复杂度为32n
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int k = 32;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int one = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1)
                    one++;
            }
            sum += (one) * (n - one);
        }
        return sum;
    }


    // 会超时
    public int totalHammingDistance1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mid = nums[i] ^ nums[j];
                sum += getOne(mid);
            }
        }
        return sum;
    }

    private int getOne(int mid) {
        int flag = 1;
        int count = 0;
        while (mid != 0) {
            if ((mid & flag) == 1)
                count++;
            mid = mid >> 1;
        }
        return count;
    }
}
