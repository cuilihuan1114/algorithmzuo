import java.util.HashMap;
import java.util.Map;

/**
     * @author cuilihuan
     * @data 2021/3/20 15:43
     */
    public  class Problem_0518_零钱兑换II {
        public int change(int amount, int[] coins) {
            if(amount == 0 && coins.length == 0)
                return 1;

            if (coins == null || coins.length == 0)
                return 0;

            Map<String, Integer> map = new HashMap<>();
            return process(amount, coins, 0, 0,map);
        }

        private int process(int amount, int[] coins, int index, int sum, Map<String, Integer> map) {

            String code = getCode(index, sum);

            if(map.containsKey(code))
                return map.get(code);

            if (index == coins.length)
                return sum == amount ? 1 : 0;

            if (sum == amount)
                return 1;
            if (sum > amount)
                return 0;

            int max = 0;
            for (int i = 0; sum + i * coins[index] <= amount; i++) {
                max = max + process(amount, coins, index + 1, sum + i * coins[index], map);
            }
            map.put(code, max);
            return max;
        }

        private String getCode(int index, int sum) {
            return "i" + index + "s" + sum;
        }
    }