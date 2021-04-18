 /**
     * @author cuilihuan
     * @data 2021/4/11 9:42
     */
    public  class Problem_0704_二分查找 {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int middle = left + (right - left) / 2;
                if(nums[middle] > target){
                    right = middle - 1;
                }else if(nums[middle] < target){
                    left = middle + 1;
                }else
                    return middle;
            }
            return -1;
        }
    }