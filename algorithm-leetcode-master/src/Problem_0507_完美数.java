import java.util.HashSet;

/**
     * @author cuilihuan
     * @data 2021/3/20 16:41
     */
    public  class Problem_0507_完美数 {

        public static void main(String[] args) {
            System.out.println(new Problem_0507_完美数().checkPerfectNumber(120));
        }

        public boolean checkPerfectNumber(int num) {
            int sum = 1;
            if(num == 1)
                return false;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 2; i <= (int)Math.sqrt(num)+1; i++) {

                if (num % i == 0) {

                    sum += i;
                    sum += (num / i);
                }
            }
            return sum == num;
        }
    }