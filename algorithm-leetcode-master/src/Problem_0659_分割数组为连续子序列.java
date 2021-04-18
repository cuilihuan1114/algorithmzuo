import java.util.HashMap;

/**
     * @author cuilihuan
     * @data 2021/4/8 15:27
     */
    public  class Problem_0659_分割数组为连续子序列 {
        public boolean isPossible(int[] nums) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            HashMap<Integer, Integer> endMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (countMap.containsKey(nums[i])) {
                    countMap.put(nums[i], countMap.get(nums[i]) + 1);
                } else
                    countMap.put(nums[i], 1);
            }

            for (int i = 0; i < nums.length; i++) {
                if (countMap.get(nums[i]) > 0) {
                    if (endMap.containsKey(nums[i] - 1) && endMap.get(nums[i] - 1) > 0) {
                        int pre = endMap.get(nums[i] - 1);
                        if(endMap.containsKey(nums[i]))
                            endMap.put(nums[i], endMap.get(nums[i]) + 1);
                        else
                            endMap.put(nums[i], 1);
                        endMap.put(nums[i] - 1, pre - 1);
                    } else {
                        int next = nums[i] + 1;
                        int next1 = nums[i] + 2;
                        if (countMap.containsKey(next) && countMap.containsKey(next1) && countMap.get(next) > 0 && countMap.get(next1) > 0) {

                            countMap.put(next, countMap.get(next) - 1);
                            countMap.put(next1, countMap.get(next1) - 1);
                            if(endMap.containsKey(next1))
                                endMap.put(next1, endMap.get(next1) + 1);
                            else
                                endMap.put(next1,  1);
                        } else
                            return false;
                    }
                    countMap.put(nums[i], countMap.get(nums[i]) - 1);
                }
            }
            return true;
        }
    }