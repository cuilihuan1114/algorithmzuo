package basic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cuilihuan
 * @data 2020/12/25 18:19
 */
public class TwoSum {
    /**
     * @param nums: the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        // write your code here
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && !set.contains(i)) {
                int otherIndex = map.get(target - nums[i]);
                if(i == otherIndex)
                    continue;
                List<Integer> cur = new ArrayList<>();
                cur.add(Math.min(i, otherIndex));
                cur.add(Math.max(i, otherIndex));
                list.add(cur);
                set.add(i);
                set.add(otherIndex);
            }
        }
        return list;
    }

    public static List<List<Integer>> twoSum1(int[] nums, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> finList = new ArrayList<>(numList);
        for (int i = 0; i < numList.size(); i++) {
            Integer numA = numList.get(i);
            Integer numB = target - numA;
            if (numList.contains(numB) && !numA.equals(numB)) {
                List<Integer> list = new ArrayList<>();
                int left = finList.indexOf(numA);
                int right = finList.indexOf(numB);
                if (left > right) {
                    left = left ^ right;
                    right = left ^ right;
                    left = left ^ right;
                }
                list.add(left);
                list.add(right);
                res.add(list);
                numList.remove(i);
                numList.remove(numB);
                i = i - 1;
            }
        }
        return res;
    }
}
