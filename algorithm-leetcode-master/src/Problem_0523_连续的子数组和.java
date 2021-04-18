import java.util.HashMap;

/**
     * @author cuilihuan
     * @data 2021/3/20 9:44
     */
    public  class Problem_0523_连续的子数组和 {
        public static void main(String[] args) {
            System.out.println(new Problem_0523_连续的子数组和().checkSubarraySum(new int[]{23, 2, 4, 0, 0}, 0));
        }

        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return false;

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(k != 0)
                    sum = sum % k;
                if(map.containsKey(sum)){
                    if(i - map.get(sum) > 1)
                        return true;
                }else
                    map.put(sum, i);
            }
            return false;
        }

        // O(n2) 可以通过 当然这个还有O(n)的时间复杂度 在这里后面会补充 利用余数的特必
        public boolean checkSubarraySum1(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return false;

    //        if (k == 0 && zeroNums(nums) >= 2)
    //            return false;

            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = (i != 0 ? res[i - 1] : 0) + nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int pre = 0;
                    if (i != 0)
                        pre = res[i - 1];
                    if (k == 0) {
                        if ((res[j] - pre == 0))
                            return true;
                    } else if ((res[j] - pre) % k == 0)
                        return true;
                }
            }

            return false;

        }

        private int zeroNums(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    count++;
            }
            return count;
        }
    }
