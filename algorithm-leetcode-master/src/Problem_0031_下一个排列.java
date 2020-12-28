/**
 * @author cuilihuan
 * @data 2020/12/2 20:00
 */
public class Problem_0031_下一个排列 {
    public static void main(String[] args) {
        new Problem_0031_下一个排列().nextPermutation(new int[]{1,2,3});
    }

    //一遍通过 牛牛牛！！！！
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int pos = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            swap(nums, findNext(nums, pos), pos);
        }
        reviser(nums, pos + 1);
    }

    private void reviser(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int next, int pos) {
        int temp = nums[next];
        nums[next] = nums[pos];
        nums[pos] = temp;
    }

    private int findNext(int[] nums, int pos) {
        for (int i = nums.length - 1; i > pos; i--) {
            if (nums[i] > nums[pos])
                return i;
        }
        return pos;
    }

}
