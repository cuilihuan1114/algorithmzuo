import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by CUI on 2021/1/11
 */
public class Problem_0264_丑数II {
    static long[] nums = new long[1691];
    static {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        queue.add(1L);
        int count = 1;
        long cur = 2;
        int[] spec = new int[]{2, 3, 5};
        while (count < 1691 ){
            cur = queue.poll();
            for (int i = 0; i < spec.length; i++) {
                if (!set.contains(cur * spec[i])) {
                    set.add(cur * spec[i]);
                    queue.add(cur * spec[i]);
                }
            }
            nums[count++] = cur;
        }
    }

    public int nthUglyNumber3(int n) {
        return (int)(nums[n]);
    }

    // 这种和上面的那一种都可以通过
    public int nthUglyNumber(int n){
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] cache = new int[n+1];
        cache[0] = 1;
        for (int i = 1; i < cache.length; i++) {
            cache[i] = Math.min(2 * cache[p2], Math.min(3 * cache[p3], 5 * cache[p5]));
            if(cache[i] == 2 * cache[p2]) p2++;
            if(cache[i] == 3 * cache[p3]) p3++;
            if(cache[i] == 5 * cache[p5]) p5++;
        }
        return cache[n - 1];
    }

    //最多过500 为啥呢？ 因为没有提前生成好所有的
    public int nthUglyNumber2(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        int count = 1;
        int cur = 2;
        while (count < n ){
            if(set.contains(cur) || (cur % 2 == 0 && set.contains(cur / 2)) || (cur % 3 == 0 && set.contains(cur / 3)) || (cur % 5 == 0 && set.contains(cur / 5))){
                set.add(cur);
                set.add(cur * 2);
                set.add(cur * 3);
                set.add(cur * 5);
                count++;
            }
            cur++;
        }
        return cur;
    }

    // 部分不行
    public int nthUglyNumber1(int n) {
        boolean[] cache = new boolean[10000];
        cache[1] = true;
        for (int i = 1; i <= 5 * n  ; i++) {
            if(cache[i]){
                cache[2 * i] = true;
                cache[3 * i] = true;
                cache[5 * i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < cache.length; i++) {
            if(cache[i]){
                count++;
                if(count == n)
                    return i;
            }
        }
        return -1;
    }
}
