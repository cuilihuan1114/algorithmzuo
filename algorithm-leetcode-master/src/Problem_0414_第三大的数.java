/**
 * @author cuilihuan
 * @data 2021/3/9 18:57
 */
public class Problem_0414_第三大的数 {
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1,max3 = max1;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > max3 && nums[i] != max2 && nums[i] != max1){
                if(nums[i] > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                }else if(nums[i] > max2){
                    max3 = max2;
                    max2 = nums[i];
                }else
                    max3 = nums[i];
            }
            min = Math.min(min,nums[i]);
        }

        //没有第二大，就返回第一大。
        if(max2 == Integer.MIN_VALUE) return max1;

        //不存在第三大的数，可能是存在多个相同的第二大的数。
        //min的作用是用于排除第三大就是Integer.MIN_VALUE的情况
        if(max3 == Integer.MIN_VALUE && min != Integer.MIN_VALUE) return max1;

        return max3; //存在第三大
    }


}
