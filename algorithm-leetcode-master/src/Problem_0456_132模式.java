import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/3/12 20:46
 */
public class Problem_0456_132模式 {

    public static void main(String[] args) {
        System.out.println(new Problem_0456_132模式().find132pattern(new int[]{3,5,0,3,4}));
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = -1;
            right[i] = -1;
        }

        int min = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[min]) {
                left[i] = min;
            } else
                min = i;
        }

        min = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[min]) {
                right[i] = min;
            } else
                min = i;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (left[i] != -1) {
                while (!stack.isEmpty() && stack.peek() <= nums[left[i]]){
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }


//        for (int i = 0; i < nums.length; i++) {
//            if (left[i] != -1 && right[i] != -1) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[left[i]] < nums[j] && nums[j] < nums[i]) {
//                        return true;
//                    }
//                }
//            }
//        }

        return false;
    }
}
