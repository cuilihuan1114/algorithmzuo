/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0283_移动零 {

    public void moveZeroes(int[] nums) {
        int left = 0 ;
        int right = 0;
        while (right < nums.length){
            if (nums[right] != 0) {
                swap(nums,left++,right);
            }
            right++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
