/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int N = nums.length;
        if (N < 2) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[N - 1] > nums[N - 2]) {
            return N - 1;
        }

        int left = 1;
        int right = N - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1])
                return mid;
            else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return left;
    }
}
