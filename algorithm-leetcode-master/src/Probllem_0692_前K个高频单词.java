
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/3/26 18:06
 */
public class Probllem_0692_前K个高频单词 {
    class Unit {
        String s;
        int num = 0;

        public Unit(String s, int num) {
            this.s = s;
            this.num = num;
        }

        public Unit() {
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0)
            return list;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else
                map.put(words[i], 1);
        }

        PriorityQueue<Unit> queue = new PriorityQueue<>(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o1.num - o2.num == 0 ? o2.s.compareTo(o1.s) : o1.num - o2.num;
            }
        });

        int count = 0;
        for (String key : map.keySet()) {
            if (count == k) {
                Unit peek = queue.peek();
                if (peek != null && peek.num < map.get(key)) {
                    queue.poll();
                    queue.add(new Unit(key, map.get(key)));
                } else if (peek.num == map.get(key)) {
                    if (peek.s.compareTo(key) > 0) {
                        queue.poll();
                        queue.add(new Unit(key, map.get(key)));
                    }
                }
            } else {
                count++;
                queue.add(new Unit(key, map.get(key)));
            }
        }

        while (!queue.isEmpty()) {
            list.add(queue.poll().s);
        }

        List<String> ans = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }

        return ans;
    }

}