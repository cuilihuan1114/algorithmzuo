import java.util.LinkedList;

/**
     * @author cuilihuan
     * @data 2021/4/11 14:28
     */
    public  class Problem_0705_设计哈希集合 {

        private final int length = 679;
        private LinkedList<Integer>[] data = new LinkedList[length];


        /** Initialize your data structure here. */
        public Problem_0705_设计哈希集合() {

        }

        public void add(int key) {
            int pos = key % length;
            if(data[pos] == null)
                data[pos] = new LinkedList<>();
            for (int i = 0; i < data[pos].size(); i++) {
                if(data[pos].get(i) == key)
                    return;
            }
            data[pos].addLast(key);
        }

        public void remove(int key) {
            int pos = key % length;
            if (data[pos] == null)
                return;
            for (int i = 0; i < data[pos].size(); i++) {
                if (data[pos].get(i) == key) {
                    data[pos].remove(i);
                    return;
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int pos = key % length;
            if (data[pos] == null)
                return false;
            for (int i = 0; i < data[pos].size(); i++) {
                if (data[pos].get(i) == key) {
                    return true;
                }
            }
            return false;
        }

        public int hash(int key){
            return key % length;
        }
    }