import java.util.Arrays;
import java.util.Comparator;

/**
     * @author cuilihuan
     * @data 2021/3/25 10:09
     */
    public  class Problem_0ffer45_把数组排成最小的数 {
        public String minNumber(int[] nums) {
            StringBuffer sb = new StringBuffer();
            if(nums == null || nums.length == 0)
                return sb.toString();

            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1+o2).compareTo(o2+o1);
                }
            });

            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
            }

            return sb.toString();
        }
    }