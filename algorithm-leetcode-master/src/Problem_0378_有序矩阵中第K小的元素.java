import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author cuilihuan
 * @data 2021/3/5 10:34
 */
public class Problem_0378_有序矩阵中第K小的元素 {

    class Info{
        int x;
        int y;
        int nums;

        public Info(int x, int y, int nums) {
            this.x = x;
            this.y = y;
            this.nums = nums;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.nums - o2.nums;
            }
        });

        int n = matrix.length;
        HashSet<String> set = new HashSet<>();
        Info cur = new Info(0, 0, matrix[0][0]);
        priorityQueue.add(cur);
        set.add(cur.toString());

        int curN = 0;
        while (!priorityQueue.isEmpty()) {
            cur = priorityQueue.poll();
            curN++;
            if(curN == k)
                return cur.nums;
            int x = cur.x;
            int y = cur.y;

            if(x + 1 < n) {
                cur = new Info(x + 1, y, matrix[x + 1][y]);
                if (!set.contains(cur.toString())) {
                    priorityQueue.add(cur);
                    set.add(cur.toString());
                }
            }

            if(y + 1 < n){
                cur =new Info(x, y + 1, matrix[x][y + 1]);
                if (!set.contains(cur.toString())) {
                    priorityQueue.add(cur);
                    set.add(cur.toString());
                }
            }
        }
        return -1;
    }
}
