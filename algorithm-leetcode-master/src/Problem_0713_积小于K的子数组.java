/**
     * @author cuilihuan
     * @data 2021/4/11 18:23
     */
    public  class Problem_0713_积小于K的子数组 {

        public static void main(String[] args) {
            System.out.println(new Problem_0713_积小于K的子数组().numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
        }

        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return 0;
            int sum = 0;
            int multi = 1;

            int left = 0;
            int right = 0;
            while (right < nums.length) {
                multi = multi * nums[right];
                while (multi >= k && left <= right) {
                    multi = multi / nums[left++];
                }

                sum += (right - left + 1);
                right++;
            }
            return sum;
        }
    }