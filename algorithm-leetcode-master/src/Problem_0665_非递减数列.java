 /**
     * @author cuilihuan
     * @data 2021/4/8 16:33
     */
    public  class Problem_0665_非递减数列 {

        public static void main(String[] args) {
            System.out.println(new Problem_0665_非递减数列().checkPossibility(new int[]{4, 2, 1}));
        }

        public boolean checkPossibility(int[] nums) {
            boolean flag = false;
            int pos = -1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    if (flag)
                        return false;
                    flag = true;
                    pos = i;
                }
            }

            if (flag) {
                if (pos + 1 < nums.length && nums[pos - 1] > nums[pos + 1]) {
                    if (pos - 2 >= 0 && nums[pos] < nums[pos - 2])
                        return false;
                }
            }
            return true;
        }
    }
