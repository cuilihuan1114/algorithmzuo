import java.util.HashMap;

/**
     * @author cuilihuan
     * @data 2021/4/4 18:32
     */
public  class Problem_0677_键值映射 {

        class Tire {
            Tire[] nexts = new Tire[26];
            int count = 0;
        }

        Tire root = new Tire();
        HashMap<String, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public Problem_0677_键值映射() {

        }

        public void insert(String key, int val) {
            int cur = val;
            if (map.containsKey(key)) {
                int pre = map.get(key);
                map.put(key, cur);
                Tire tmp = root;
                for (int i = 0; i < key.length(); i++) {
                    tmp = tmp.nexts[key.charAt(i) - 'a'];
                    tmp.count -= pre;
                }
            } else {
                map.put(key, val);
            }

            Tire tmp = root;
            for (int i = 0; i < key.length(); i++) {
                if (tmp.nexts[key.charAt(i) - 'a'] == null)
                    tmp.nexts[key.charAt(i) - 'a'] = new Tire();
                tmp = tmp.nexts[key.charAt(i) - 'a'];
                tmp.count += cur;
            }
        }

        public int sum(String prefix) {
            Tire tmp = root;
            for (int i = 0; i < prefix.length(); i++) {
                if(tmp.nexts[prefix.charAt(i) - 'a'] == null)
                    return 0;
                tmp = tmp.nexts[prefix.charAt(i) - 'a'];
            }
            return tmp.count;
        }
    }