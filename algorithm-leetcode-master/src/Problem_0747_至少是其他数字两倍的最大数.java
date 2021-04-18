/**
     * @author cuilihuan
     * @data 2021/4/12 14:10
     */
    public  class Problem_0747_至少是其他数字两倍的最大数 {
        public int dominantIndex(int[] nums) {
            if(nums == null || nums.length == 0)
                return -1;

            int max = 0;
            int pos = -1;
            for (int i = 0; i < nums.length; i++) {
                if(max < nums[i]){
                    max = nums[i];
                    pos = i;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if(i != pos && nums[i] != 0 && max / nums[i] < 2)
                    return -1;
            }

            return pos;
        }
    }