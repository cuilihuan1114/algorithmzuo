import java.util.TreeMap;

/**
     * @author cuilihuan
     * @data 2021/4/11 19:43
     */
    public  class Problem_0731_我的日程安排表II {

        TreeMap<Integer, Integer> delta = new TreeMap<>();

        public Problem_0731_我的日程安排表II() {
            delta = new TreeMap();
        }

        public boolean book(int start, int end) {

            delta.put(start, delta.getOrDefault(start, 0) + 1);
            delta.put(end, delta.getOrDefault(end, 0) - 1);

            int active = 0;
            for(int d : delta.values()){
                active += d;
                if(active >= 3){
                    delta.put(start, delta.get(start) - 1);
                    delta.put(end, delta.get(end) + 1);
                    if(delta.get(start) == 0)
                        delta.remove(start);
                    return false;
                }
            }

            return true;

        }
    }