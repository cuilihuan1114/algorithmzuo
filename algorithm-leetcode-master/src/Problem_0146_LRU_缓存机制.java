import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by CUI on 2021/1/3
 */
public class Problem_0146_LRU_缓存机制 {

    public static void main(String[] args) {
        Problem_0146_LRU_缓存机制 lru = new Problem_0146_LRU_缓存机制(1);
        lru.put(2, 1);
        lru.get(2);
        lru.put(3, 2);
        lru.get(2);
        System.out.println(lru.get(3));
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }

    class cache {
        int capacity = 0;
        HashMap<Integer, Node> hashMap = new HashMap<>();
        Node head = null;
        Node tail = null;

        public cache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                Node cur = hashMap.get(key);
                removeToTail(cur);
                return cur.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                Node cur = hashMap.get(key);
                cur.value = value;
                removeToTail(cur);
            } else {
                Node node = new Node();
                node.key = key;
                node.value = value;
                if (hashMap.size() >= capacity) {
                    removeHead();
                }
                hashMap.put(key, node);
                addLast(node);
            }
        }

        private void addLast(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        private void removeHead() {
            if (head == null)
                return;
            hashMap.remove(head.key);
            if (head == tail) {
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            head.pre = null;
        }

        private void removeToTail(Node cur) {
            if (cur == tail)
                return;
            if (cur == head) {
                head = cur.next;
                if (head != null)
                    head.pre = null;
            } else {
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
            }

            tail.next = cur;
            cur.pre = tail;
            tail = cur;
            cur.next = null;

        }


    }

    cache cache = null;

    public Problem_0146_LRU_缓存机制(int capacity) {
        cache = new cache(capacity);
    }

    public int get(int key) {
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
