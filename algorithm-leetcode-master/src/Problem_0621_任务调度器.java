import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CUI on 2021/2/26
 */
public class Problem_0621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
            max = Math.max(max, count[tasks[i] - 'A']);
        }

        int nums = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] == max)
                nums++;
        }

        int restTask = tasks.length - nums;
        int allBlank = (n + 1) * (max - 1);
        return restTask > allBlank ? tasks.length : allBlank + nums;
//        int restBlank = Math.max(0, allBlank - restTask);
//        return tasks.length + restBlank;
    }






}
