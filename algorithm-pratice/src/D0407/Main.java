package D0407;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/11 10:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        List<Integer> tuanPos = new ArrayList<>();
        int[] prices = new int[N];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = input.nextInt();
            if (prices[i] == 0)
                tuanPos.add(i);
        }

        int pos = -1;
        double distance = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= K  && prices[i] != 0) {
                int sum = 0;
                for (int j = 0; j < tuanPos.size(); j++) {
                    sum  += Math.abs(i - tuanPos.get(j) + 1);
                }
                double temp = sum / (double) tuanPos.size();
                if (temp < distance) {
                    distance = temp;
                    pos = i;
                }
            }
        }
        System.out.println(pos + 1);
    }
}
