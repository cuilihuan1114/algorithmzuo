import java.util.HashMap;
import java.util.*;

/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else
                map.put(nums[i], 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if(priorityQueue.size() < k){
                priorityQueue.add(new int[]{key, count});
            }else if(priorityQueue.size() == k){
                int[] peek = priorityQueue.peek();
                if(peek[1] < count){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, count});
                }
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (priorityQueue.size() > 0){
            res[i] = priorityQueue.poll()[0];
            i++;
        }

        return res;

    }
}
