package D0421;

import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/4/18 20:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fruitNum = input.nextInt();
        int problemNum = input.nextInt();
        int[] array = new int[fruitNum];
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < fruitNum; j++) {
            array[j] = input.nextInt();
            set.add(array[j]);
        }
        for (int i = 0; i < problemNum; i++) {
            int target = input.nextInt();
            boolean flag = false;
            for (int j = 0; j < fruitNum; j++) {
                if (set.contains(array[j] + target)) {
                    flag = true;
                    System.out.println(array[j] + " " + (array[j] + target));
                    break;
                }
            }
            if (!flag) {
                System.out.println("-1" + " " + "-1");
            }
        }
    }
}
