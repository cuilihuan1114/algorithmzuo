/**
 * @author cuilihuan
 * @data 2020/11/21 14:32
 */
public class Problem_0011_盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(new Problem_0011_盛最多水的容器().maxArea(new int[]{4, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //[4,8,6,2,5,4,8,3,7]
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
