import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
     * @author cuilihuan
     * @data 2021/3/24 18:53
     */
    public  class Problem_0546_移除盒子 {

        public static void main(String[] args) {
            System.out.println(new Problem_0546_移除盒子().removeBoxes(new int[]{1, 1, 1}));
        }

        public int removeBoxes(int[] boxes) {
            if (boxes == null || boxes.length == 0)
                return 0;

    //        int[] dp = new int[boxes.length];
    //        for (int i = 0; i < boxes.length; i++) {
    //            if (i != 0 && boxes[i] == boxes[i - 1]) {
    //                dp[i] = dp[i - 1] + 1;
    //                dp[i - 1] = 0;
    //            } else
    //                dp[i] = 1;
    //        }
    //        int sum = 0;
    //        for (int i = 0; i < dp.length; i++) {
    //            if (dp[i] > 0)
    //                sum++;
    //        }
    //
    //        int[] curBox = new int[sum];
    //        int[] curDP = new int[sum];
    //
    //        int j = 0;
    //        for (int i = 0; i < dp.length; i++) {
    //            if (dp[i] != 0) {
    //                curBox[j] = boxes[i];
    //                curDP[j] = dp[i];
    //                j++;
    //            }
    //        }
    //        System.out.println(j == sum);
    //        System.out.println(boxes.length);
    //        System.out.println(sum);


            Map<String, Integer> map = new HashMap<>();

            return process(boxes, 0, boxes.length - 1, -1, 0, map);
        }

        private int process(int[] boxes, int start, int end, int pre, int preCount, Map<String, Integer> map) {

            if (start == end) {
                if (boxes[start] == pre)
                    return (preCount + 1) * (preCount + 1);
                else
                    return preCount * preCount + 1;
            }

            String code = getHashCode(start, end, pre, preCount);

            if(map.containsKey(code))
                return map.get(code);

            if (start > end)
                return preCount * preCount;

            int j = start;
            for (; j <= end; j++) {
                if (boxes[j] == pre) {
                    preCount++;
                } else
                    break;
            }

            if (j == end + 1)
                return preCount * preCount;

            start = j;
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int cur = boxes[start];
            for (int i = start; i <= end; i++) {
                if (cur == boxes[i]) {
                    int p1 = process(boxes, start + 1, i - 1, cur, i == start ? 1 : 2, map);
                    int p2 = process(boxes, i + 1, end, pre, preCount, map);
                    sum = p1 + p2;
                    max = Math.max(max, sum);
                }
            }

            map.put(code, max);
            return max;
        }

        private String getHashCode(int start, int end, int pre, int preCount) {
            return start + "_" + end + "_" + pre + "_" + preCount;
        }


        private int process1(int[] boxes, int start, int end, Map<String, Integer> map) {

            if (start == end)
                return 1;
            if (start > end)
                return 0;

            String code = getHashCode(start, end, start, end);
            if (map.containsKey(code))
                return map.get(code);


            int cur = boxes[start];

            List<Integer> list = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                if (boxes[i] == cur)
                    list.add(i);
            }
            list.add(end + 1);
            int[] max = new int[1];
            getSort(boxes, list, 0, 0, list.get(0), 0, max, map);


            map.put(code, max[0]);
            return max[0];
        }

        private void getSort(int[] boxes, List<Integer> list, int index, int sum, int pre, int count, int[] max, Map<String, Integer> map) {
            if (index == list.size()) {
                max[0] = Math.max((count) * (count) + sum, max[0]);
                return;
            }
            getSort(boxes, list, index + 1, sum, pre, count, max, map);
            if (index != 0) {
                int ans = process1(boxes, pre + 1, list.get(index) - 1, map);
                getSort(boxes, list, index + 1, sum + ans, list.get(index), count + 1, max, map);
            }


        }


    }