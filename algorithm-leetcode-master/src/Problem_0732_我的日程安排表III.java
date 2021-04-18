import java.util.TreeMap;

/**
     * @author cuilihuan
     * @data 2021/4/11 19:56
     */
    public  class Problem_0732_我的日程安排表III {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public Problem_0732_我的日程安排表III() {

        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);


            int max = 0;
            int ans = 0;
            for(int value : map.values()){
                max += map.get(value);
                ans = Math.max(ans, max);
            }
            return ans;
        }
    }