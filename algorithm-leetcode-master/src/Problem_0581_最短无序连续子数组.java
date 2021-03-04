/**
 * Created by CUI on 2021/2/26
 */
public class Problem_0581_最短无序连续子数组 {

    public static void main(String[] args) {
        new Problem_0581_最短无序连续子数组().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] copyNums = new int[nums.length + 2];
        copyNums[0] = Integer.MIN_VALUE;
        for (int i = 1; i < copyNums.length - 1; i++) {
            copyNums[i] = nums[i - 1];
        }
        copyNums[copyNums.length - 1] = Integer.MAX_VALUE;

        int end = copyNums.length - 1;
        boolean flag = true;
        for (int i = copyNums.length - 2; i >= 0; i--) {
            if (copyNums[i] <= copyNums[end] && flag) {
                end = i;
            } else {
                flag = false;
                end = backPosition(copyNums, i, end);
            }
        }

        int start = 0;
        flag = true;
        for (int i = 1; i < copyNums.length; i++) {
            if (copyNums[i] >= copyNums[start] && flag)
                start = i;
            else {
                flag = false;
                start = postPostion(copyNums, i, start);
            }
        }

        return Math.max(0, end - start - 1);
    }

    private int postPostion(int[] copyNums, int i, int start) {
        while (start > 0 && copyNums[start] > copyNums[i])
            start--;
        return start;
    }

    private int backPosition(int[] nums, int i, int end) {
        while (end < nums.length - 1 && nums[i] > nums[end]) {
            end++;
        }
        return end;
    }
}
