package D0414;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/9 18:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] split = input.next().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int K = input.nextInt();
        int[] res = new int[nums.length - K + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int right = 0; right < nums.length; right++) {

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                queue.pollLast();
            }
            queue.addLast(right);
            if (queue.peekFirst() == right - K) {
                queue.pollFirst();
            }
            if (right >= K - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        System.out.print("[");
        System.out.print(res[0]);
        for (int i = 1; i < res.length; i++) {
            System.out.print("," + res[i]);
        }
        System.out.println("]");
    }
}
