import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CUI on 2021/1/12
 */
public class Problem_0313_超级丑数 {
    public static void main(String[] args) {
        Long a = 0L;
        System.out.println(a == 0L);
    }



    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int primesNumber = primes.length, min = 1, next = 1;
        int[] primeIndexes = new int[primesNumber];
        int[] tempPrimes = new int[primesNumber];

        Arrays.fill(tempPrimes, 1);

        for (int i = 0; i < n; i++) {
            uglyNumbers[i] = min;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < tempPrimes.length; j++) {
                if (tempPrimes[j] == next) {
                    tempPrimes[j] = primes[j] * uglyNumbers[primeIndexes[j]];
                    primeIndexes[j]++;
                }
                min = Math.min(tempPrimes[j], min);
            }
            next = min;
        }

        return uglyNumbers[n - 1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long cur = 1L;
        queue.add(1L);
        for (int i = 1; i <= n; i++) {
            cur = queue.poll();
            for (int j = 0; j < primes.length; j++) {
                queue.add(primes[j] * cur);
            }
            while (!queue.isEmpty() && queue.peek() == cur)
                queue.poll();
        }
        return (int)cur;

    }
}
