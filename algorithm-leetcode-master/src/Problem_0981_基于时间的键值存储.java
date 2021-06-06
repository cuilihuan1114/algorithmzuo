
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/6/1 10:08
 */


public class Problem_0981_基于时间的键值存储 {


    public static void main(String[] args) {
        Problem_0981_基于时间的键值存储 test = new Problem_0981_基于时间的键值存储();
        test.set("foo", "bar", 1);
        System.out.println(test.get("foo", 1));
    }

    class Info {
        String value;
        int time;

        public Info(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    HashMap<String, List<Info>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Problem_0981_基于时间的键值存储() {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Info(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        List<Info> list = map.get(key);
        int pos = binSearch(list, timestamp);
        return pos != -1 ? list.get(pos).value : "";
    }

    private int binSearch(List<Info> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid).time <= timestamp)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return end < 0  ? -1 : end;
    }
}
