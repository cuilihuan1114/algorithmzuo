/**
 * @author cuilihuan
 * @data 2020/11/25 10:51
 */
public class Problem_0035_搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(new Problem_0035_搜索插入位置().searchInsert(new int[]{1, 3, 5,6,7, 7}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }


    public int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
