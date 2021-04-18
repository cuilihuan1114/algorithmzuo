/**
     * @author cuilihuan
     * @data 2021/4/11 19:20
     */
    public  class Problem_0724_寻找数组的中心下标 {
        public int pivotIndex(int[] nums) {
            int sum = 0;
            int[] right = new int[nums.length+1];
            right[nums.length] = 0;
            for (int i = nums.length - 1; i >= 0 ; i--) {
                sum += nums[i];
                right[i] = sum;
            }

            sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if(sum == right[i+1])
                    return i;
                sum += nums[i];
            }

            return -1;
        }
    }
