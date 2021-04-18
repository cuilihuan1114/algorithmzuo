 /**
     * @author cuilihuan
     * @data 2021/3/20 18:29
     */
    public  class Problem_0509_斐波那契数 {
        public int fib(int n) {
            if(n==0) return 0;
            if(n==1) return 1;
            int first = 0;
            int second = 1;
            int cur = 0;
            for (int i = 2; i <= n; i++) {
                cur = first + second;
                first = second;
                second = cur;
            }
            return cur;
        }
    }