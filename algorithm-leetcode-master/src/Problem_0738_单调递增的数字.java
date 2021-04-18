/**
     * @author cuilihuan
     * @data 2021/4/12 10:44
     */
    public  class Problem_0738_单调递增的数字 {

        public static void main(String[] args) {
            System.out.println(new Problem_0738_单调递增的数字().monotoneIncreasingDigits(10));
        }


        public int monotoneIncreasingDigits(int N) {
            char[] c = String.valueOf(N).toCharArray();

            int i = 1;
            for (; i < c.length; i++) {
                if (c[i] < c[i - 1])
                    break;
            }

            if (i == c.length)
                return N;

            int index = i - 1;
            for (int j = index; j >= 0; j--) {
                c[j] = (char) (c[j] - 1);
                if (j == 0 || c[j] >= c[j - 1]) {
                    index = j;
                    break;
                }
            }


            for (int j = index + 1; j < c.length; j++) {
                c[j] = '9';
            }

            int sum = 0;
            for (int j = 0; j < c.length; j++) {
                sum = sum * 10 + c[j] - '0';
            }

            if (sum > N)
                sum = sum / 10;
            return sum;

        }
    }