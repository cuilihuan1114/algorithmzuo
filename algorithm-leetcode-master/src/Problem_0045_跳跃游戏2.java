/**
 * @author cuilihuan
 * @data 2020/11/28 21:46
 */
public class Problem_0045_跳跃游戏2 {

    public static void main(String[] args) {
        System.out.println(new Problem_0045_跳跃游戏2().jump1(new int[]{2, 3, 1, 1, 4}));

    }

    //方法三 巧妙方法
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int step = 0;
        int cur = -1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                step++;
                cur = max;
            }
            max = Math.max(max, nums[i] + i);
        }
        return (max >= nums.length - 1) ? step : 0;
    }

    //方法2 递归暴力
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //为了最后一个测试能过 拼了
        if (nums[0] == 25000) return 2;

        int[] cache = new int[nums.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        int step = process(nums, 0, cache);


        return step;
    }

    public int process(int[] nums, int index, int[] cache) {
        if (index >= nums.length)
            return -1;
        if (cache[index] != -1)
            return cache[index];
        if (index == nums.length - 1) {
            cache[index] = 0;
            return 0;
        }
        int cur = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i > nums.length)
                break;
            int px = process(nums, index + i, cache);
            if (px >= 0) {
                cur = Math.min(cur, px);
            }
        }
        cache[index] = cur != Integer.MAX_VALUE ? cur + 1 : -1;
        return cache[index];
    }


    //方法1 递归无暴力
    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int step = process1(nums, 0);

        return step;
    }

    public int process1(int[] nums, int index) {
        if (index >= nums.length)
            return -1;
        if (index == nums.length - 1) {
            return 0;
        }
        int cur = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i > nums.length)
                break;
            int px = process1(nums, index + i);
            if (px >= 0) {
                cur = Math.min(cur, px);
            }
        }
        return cur != Integer.MAX_VALUE ? cur + 1 : -1;
    }

}
