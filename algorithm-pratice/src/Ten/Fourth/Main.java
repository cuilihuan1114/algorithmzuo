package Ten.Fourth;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/4 21:11
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        int left = 0;
        int right = nums.length - 1;
        System.out.println(process(nums, left, right));

    }

    private static int process(int[] nums, int left, int right) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int target = (max + min) / 2;
        int leftNums = 0;
        int rightNums = 0;
        for (int i = left; i <= right ; i++) {
            if(nums[i] <= target)
                leftNums++;
            else
                rightNums++;
        }
        int len = right - left + 1;
        if(leftNums == len || rightNums == len)
            return 0;

        int[] l = new int[leftNums];
        int[] r = new int[rightNums];
        int lNext = 0;
        int rNext = 0;

        int sum = 0;
        for (int i = left; i <= right ; i++) {
            if(nums[i] <= target) {
                l[lNext++] = nums[i];
            }
            else {
                r[rNext++] = nums[i];
            }
            sum += nums[i];
        }

        sum += process(l, 0, l.length - 1);
        sum += process(r, 0, r.length - 1);
        return sum;
    }
}
