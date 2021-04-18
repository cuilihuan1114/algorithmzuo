import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/3/13 9:10
 */
public class Problem_0451_根据字符出现频率排序 {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else
                map.put(s.charAt(i),1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for(Character key : map.keySet()){
            priorityQueue.add(new int[]{key,map.get(key)});
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            int[] cur = priorityQueue.poll();
            for (int i = 0; i < cur[1]; i++) {
                sb.append((char)cur[0]);
            }
        }
        return sb.toString();
    }
}
