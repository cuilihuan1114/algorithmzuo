package newke;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/3/26 18:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int k = 0; k < n; k++) {
            int count = scanner.nextInt();
            int[] nums = new int[count];
            for (int j = 0; j < count; j++) {
                nums[j] = scanner.nextInt();
            }


            int max = 0;
            int sum = 0;
            int[] left = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    left[i] = sum;
                    max = Math.max(sum, max);
                    sum = 0;
                } else
                    sum++;
            }


            if(max == 0){
                System.out.println(nums.length - 1);
                continue;
            }

            int[] right = new int[nums.length];
            sum = 0;
            for (int i = nums.length - 1; i >= 0 ; i--) {
                if (nums[i] == 0) {
                    right[i] = sum;
                    sum = 0;
                } else
                    sum++;
            }

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){

                    if(left[i] + right[i] > max){
                        max = left[i] + right[i];
                    }
                }
            }
            System.out.println(max);
        }
    }
}
