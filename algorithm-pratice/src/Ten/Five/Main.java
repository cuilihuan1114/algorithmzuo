package Ten.Five;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/4 21:29
 */
public class Main {

    static class Essay {
        int count = 0;
        int pre = -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        HashMap<String, Integer>[] info = new HashMap[N];
        HashMap<String, Essay> other = new HashMap<>();
        for (int i = 0; i < N; i++) {
            info[i] = new HashMap<>();
            int count = input.nextInt();
            for (int j = 0; j < count; j++) {
                String word = input.next();
                if (info[i].containsKey(word)) {
                    info[i].put(word, info[i].get(word) + 1);
                } else
                    info[i].put(word, 1);

                if (other.containsKey(word)) {
                    Essay essay = other.get(word);
                    if (essay.pre != i) {
                        essay.pre = i;
                        essay.count++;
                    }
                } else {
                    Essay essay = new Essay();
                    essay.pre = i;
                    essay.count = essay.count + 1;
                    other.put(word, essay);
                }

            }
        }


        for (int i = 0; i < info.length; i++) {
            HashMap<String, Integer> cur = info[i];
            double ans = 0;
            for (String key : cur.keySet()) {
                int count = cur.get(key);
                int num = other.get(key).count;
                ans = Math.max(count / (double) (num), ans);
            }
            System.out.println(ans);
        }

    }
}
