import java.util.LinkedList;

/**
     * @author cuilihuan
     * @data 2021/4/11 14:38
     */
    public  class Problem_0706_设计哈希映射 {

        class Node {
            int key;
            int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }


        private final int length = 679;
        private LinkedList<Node>[] data = new LinkedList[length];


        /**
         * Initialize your data structure here.
         */
        public Problem_0706_设计哈希映射() {

        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int pos = key % length;
            if (data[pos] == null)
                data[pos] = new LinkedList<>();
            for (int i = 0; i < data[pos].size(); i++) {
                if (data[pos].get(i).key == key) {
                    data[pos].get(i).val = value;
                    return;
                }
            }
            data[pos].addLast(new Node(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int pos = key % length;
            if (data[pos] == null)
                return -1;
            for (int i = 0; i < data[pos].size(); i++) {
                if (data[pos].get(i).key == key) {
                    return data[pos].get(i).val;
                }
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int pos = key % length;
            if (data[pos] == null)
                return;
            for (int i = 0; i < data[pos].size(); i++) {
                if (data[pos].get(i).key == key) {
                    data[pos].remove(i);
                    return;
                }
            }
        }

        public int hash(int key) {
            return key % length;
        }
    }