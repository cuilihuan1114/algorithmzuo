import java.util.LinkedList;

/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] max = new int[nums.length - k + 1];
        int R = 0;
        int L = 0;
        while (R < nums.length){
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[R]){
                queue.pollLast();
            }
            queue.addLast(R++);
            if(R - L == k){
                max[L] = nums[queue.peekFirst()];
                L++;
            }
            if(queue.peekFirst() < L)
                queue.pollFirst();
        }
        return max;
    }
}
