package D0314;

import java.util.HashMap;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/21 19:55
 */
public class Problem_0638_大礼包 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<String, Integer> map = new HashMap<>();
        return process(price, special, needs, map);
    }

    private int process(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<String, Integer> map) {

        String code = getHashCode(needs);
        if (map.containsKey(code))
            return map.get(code);

        if (isEmpty(needs)) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            int sum = 0;
            boolean flag = false;

            if (isBuy(special.get(i), needs)) {
                sum += special.get(i).get(special.get(i).size() - 1);
                toDerice(special.get(i), needs);
                sum += process(price, special, needs, map);
                toAdd(special.get(i), needs);
                flag = true;
            }

            if (flag)
                max = Math.min(max, sum);
        }

        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) > 0) {
                sum += needs.get(i) * price.get(i);
            }
        }
        max = Math.min(sum, max);

        map.put(code, max);
        return max;

    }

    private String getHashCode(List<Integer> needs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(needs.get(i));
            sb.append("_");
        }
        return sb.toString();
    }

    private void toAdd(List<Integer> buyNums, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) + buyNums.get(i));
        }

    }

    private void toDerice(List<Integer> buyNums, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) - buyNums.get(i));
        }
    }

    private boolean isBuy(List<Integer> buyNums, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < buyNums.get(i))
                return false;
        }
        return true;
    }

    private boolean isEmpty(List<Integer> needs) {

        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) != 0)
                return false;
        }

        return true;


    }
}