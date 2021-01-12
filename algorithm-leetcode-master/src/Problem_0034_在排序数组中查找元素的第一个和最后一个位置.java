/**
 * @author cuilihuan
 * @data 2020/11/25 14:21
 */
public class Problem_0034_在排序数组中查找元素的第一个和最后一个位置 {


    public static void main(String[] args) {
        int[] ints = new Problem_0034_在排序数组中查找元素的第一个和最后一个位置().searchRange(new int[]{2, 2}, 3);
        System.out.println(ints[0] + " " + ints[1]);
    }


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int first = firstPosition(nums, target);
        int second = secondPosition(nums, target);
        return (first < nums.length && nums[first] == target) ? new int[]{first, second - 1} : new int[]{-1, -1};
    }

    private int secondPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    private int firstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}
