import java.util.PriorityQueue;

/**
 * @author cuilihuan
 * @data 2021/4/11 14:54
 */
public class Problem_0703_数据流中的第K大元素 {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int count = 0;
    int k = 0;

    public Problem_0703_数据流中的第K大元素(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (count < k) {
                queue.add(nums[i]);
                count++;
            } else {
                Integer peekNum = queue.peek();
                if (peekNum < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        int ans = 0;
        if (count < k) {
            queue.add(val);
            ans = queue.peek();
            count++;
        } else {
            ans = queue.peek();
            if (ans < val) {
                queue.poll();
                queue.add(val);
            }
            ans = queue.peek();
        }
        return ans;
    }
}