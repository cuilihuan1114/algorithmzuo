/**
 * @author cuilihuan
 * @data 2020/11/25 10:39
 */
public class Problem_0042_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum  = 0;
        int left = 0;
        int leftMax = height[0];
        int right = height.length - 1;
        int rightMax = height[height.length - 1];
        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                sum += (leftMax > height[left] ? leftMax - height[left] : 0);
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                sum += (rightMax > height[right] ? rightMax - height[right] : 0);
                right--;
            }
        }
        return sum;
    }
}
