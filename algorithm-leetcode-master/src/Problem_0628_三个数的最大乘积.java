/**
 * @author cuilihuan
 * @data 2021/3/23 16:46
 */
public class Problem_0628_三个数的最大乘积 {
    public static void main(String[] args) {
        System.out.println(new Problem_0628_三个数的最大乘积().maximumProduct(new int[]{1, 2, 3}));
    }
    public int maximumProduct(int[] nums) {
        int max1 = getMax(nums, -1,-1);
        int max2 = getMax(nums, max1,-1);
        int max3 = getMax(nums, max2,max1);

        int min1 = getMin(nums, -1);
        int min2 = getMin(nums, min1);

        return Math.max(nums[max1] * nums[max2] * nums[max3], nums[max1] * nums[min1] * nums[min2]);
    }

    private int getMin(int[] nums, int maxValue) {
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i != maxValue){
                if(nums[i] < min) {
                    min = nums[i];
                    pos = i;
                }
            }

        }
        return pos;
    }

    private int getMax(int[] nums, int pre,int prepre) {
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i != pre && i != prepre) {
                if(max < nums[i]) {
                    max = nums[i];
                    pos = i;
                }
            }
        }
        return pos;
    }
}
