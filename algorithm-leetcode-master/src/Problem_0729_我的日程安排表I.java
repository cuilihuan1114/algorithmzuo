import java.util.TreeMap;

/**
     * @author cuilihuan
     * @data 2021/4/12 10:05
     */
    public  class Problem_0729_我的日程安排表I {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public boolean book(int start, int end) {
            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
            int num = 0;
            for (Integer value : treeMap.values()) {
                num += value;
                if (num >= 2) {
                    treeMap.put(start, treeMap.getOrDefault(start, 0) - 1);
                    treeMap.put(end, treeMap.getOrDefault(end, 0) + 1);
                    return false;
                }
            }
            return true;
        }
    }