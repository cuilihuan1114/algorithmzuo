import java.util.HashMap;

/**
     * @author cuilihuan
     * @data 2021/3/19 9:07
     */
    public  class Problem_0460_LFU缓存 {

        private int capacity = 0;
        // 计数
        private HashMap<Integer,Integer> count;



        public Problem_0460_LFU缓存(int capacity){
            this.capacity = capacity;
            count = new HashMap<>();

        }


        public int get(int key) {
            return 0;

        }

        public void put(int key, int value) {

        }
    }