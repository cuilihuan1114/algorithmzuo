/**
 * @author cuilihuan
 * @data 2020/12/5 21:29
 */
public class Problem_0091_解码方法 {

    public static void main(String[] args) {
        System.out.println(new Problem_0091_解码方法().numDecodings("27"));
    }

    public int numDecodings(String s){
        if (s == null || s.length() == 0)
            return 0;
        char[] c = s.toCharArray();
        int[] dp = new int[c.length + 1];
        dp[c.length] = 1;
        for (int index = c.length - 1; index >=0 ; index--) {
            int sum = 0;
            if (c[index] >= '1' && c[index] <= '9')
                sum += dp[index + 1];
            if (c[index] == '1') {
                if (index + 1 < c.length)
                    sum += dp[index + 2];
            }
            if (c[index] == '2') {
                if (index + 1 < c.length && (c[index+1] >= '0' && c[index+1] <= '6'))
                    sum += dp[index + 2];
            }
            dp[index] = sum;
        }
        return dp[0];
    }


    public int numDecodings2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] c = s.toCharArray();
        int[] cahce = new int[c.length + 1];
        for (int i = 0; i < cahce.length; i++) {
            cahce[i] = -1;
        }
        return process1(c, 0, cahce);
    }

    private int process1(char[] c, int index, int[] cache) {
        if (index > c.length)
            return 0;
        if (cache[index] != -1)
            return cache[index];

        if (index == c.length)
            return 1;

        int sum = 0;
        if (c[index] >= '1' && c[index] <= '9')
            sum += process1(c, index + 1, cache);


        if (c[index] == '1') {
            if (index + 1 < c.length)
                sum += process1(c, index + 2, cache);
        }
        if (c[index] == '2') {
            if (index + 1 < c.length && (c[index+1] >= '0' && c[index+1] <= '6'))
                sum += process1(c, index + 2, cache);
        }
        cache[index] = sum;
        return sum;
    }

    public int numDecodings1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] c = s.toCharArray();
        return process(c, 0);
    }

    private int process(char[] c, int index) {
        if (index > c.length)
            return 0;

        if (index == c.length)
            return 1;

        int sum = 0;
        if (c[index] >= '1' && c[index] <= '9')
            sum += process(c, index + 1);


        if (c[index] == '1') {
            if (index + 1 < c.length)
                sum += process(c, index + 2);
        }
        if (c[index] == '2') {
            if (index + 1 < c.length && (c[index+1] >= '0' && c[index+1] <= '6'))
                sum += process(c, index + 2);
        }
        return sum;
    }

}
