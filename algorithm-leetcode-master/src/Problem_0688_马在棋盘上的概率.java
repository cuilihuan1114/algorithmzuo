import java.util.HashMap;
import java.util.Map;

/**
     * @author cuilihuan
     * @data 2021/4/4 18:57
     */
    public  class Problem_0688_马在棋盘上的概率 {

        public static void main(String[] args) {
            System.out.println(new Problem_0688_马在棋盘上的概率().knightProbability(3, 2, 0, 0));
        }


        public double knightProbability(int N, int K, int r, int c) {
            Map<String, Double> map = new HashMap<>();
            double p = process(N, K, r, c, map);

            return p;
        }

        private double process(int N, int cur, int x, int y, Map<String, Double> map) {
            String code = getCode(cur, x, y);
            if(map.containsKey(code))
                return map.get(code);

            if (x < 0 || x >= N || y < 0 || y >= N) {
                return 0;
            }

            if (cur == 0) {
                return 1.0;
            }

            double sum = 0;
            sum += process(N, cur - 1, x - 2, y + 1, map);
            sum += process(N, cur - 1, x - 1, y + 2, map);
            sum += process(N, cur - 1, x + 1, y + 2, map);
            sum += process(N, cur - 1, x + 2, y + 1, map);
            sum += process(N, cur - 1, x + 2, y - 1, map);
            sum += process(N, cur - 1, x + 1, y - 2, map);
            sum += process(N, cur - 1, x - 1, y - 2, map);
            sum += process(N, cur - 1, x - 2, y - 1, map);

            map.put(code, sum / 8.0);
            return sum / 8.0;
        }

        private String getCode(int cur, int x, int y) {
            return cur + "_" + x + "_" + y;
        }






        public double knightProbability1(int N, int K, int r, int c) {
            double p = process1(N, K, r, c);

            return p;
        }


        // 暴力超时
        private double process1(int N, int cur, int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) {
                return 0;
            }

            if (cur == 0) {
                return 1.0;
            }

            double sum = 0;
            sum += process1(N, cur - 1, x - 2, y + 1);
            sum += process1(N, cur - 1, x - 1, y + 2);
            sum += process1(N, cur - 1, x + 1, y + 2);
            sum += process1(N, cur - 1, x + 2, y + 1);
            sum += process1(N, cur - 1, x + 2, y - 1);
            sum += process1(N, cur - 1, x + 1, y - 2);
            sum += process1(N, cur - 1, x - 1, y - 2);
            sum += process1(N, cur - 1, x - 2, y - 1);

            return sum / 8.0;
        }


    }