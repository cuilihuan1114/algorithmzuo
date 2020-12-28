/**
 * @author cuilihuan
 * @data 2020/11/26 11:05
 */
public class Problem_0027_移除元素 {

    public static void main(String[] args) {
        System.out.println(new Problem_0027_移除元素().removeElement(new int[]{3, 2, 2, 3}, 3));
    }


    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length == 0)
            return 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                swap(nums, left++, val);
            }
        }
        return left;
    }

    private void swap(int[] nums, int i, int val) {
        int tem = nums[i];
        nums[i] = nums[val];
        nums[val] = tem;
    }
}
