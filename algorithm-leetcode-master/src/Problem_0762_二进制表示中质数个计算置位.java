/**
     * @author cuilihuan
     * @data 2021/4/12 20:31
     */
    public  class Problem_0762_二进制表示中质数个计算置位 {
        public int countPrimeSetBits(int L, int R) {
            int ans = 0;
            for (int x = L; x <= R; ++x)
                if (isSmallPrime(getBitCount(x)))
                    ans++;
            return ans;
        }
        public boolean isSmallPrime(int x) {
            return (x == 2 || x == 3 || x == 5 || x == 7 ||
                    x == 11 || x == 13 || x == 17 || x == 19);
        }

        public int getBitCount(int x){
            int sum = 0;
            while (x != 0){
                sum += ((x & 1) == 0 ? 0 : 1);
                x = x >> 1;
            }
            return sum;
        }
    }