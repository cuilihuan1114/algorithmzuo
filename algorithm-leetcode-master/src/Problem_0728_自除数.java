import java.util.ArrayList;
import java.util.List;

/**
     * @author cuilihuan
     * @data 2021/4/12 10:00
     */
    public  class Problem_0728_自除数 {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> list = new ArrayList<>();
            for (int i = left; i <= right ; i++) {
                if(isZhiRan(i)){
                    list.add(i);
                }
            }
            return list;
        }

        private boolean isZhiRan(int num) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                int cur = s.charAt(i) - '0';
                if(cur == 0 || num % cur != 0)
                    return false;

            }
            return true;
        }
    }