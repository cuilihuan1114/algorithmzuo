/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0321_拼接最大数 {


    public static void main(String[] args) {

        System.out.println(new Problem_0321_拼接最大数().maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15).length);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[][] cache1 = getDP(nums1);
        int[][] cahce2 = getDP(nums2);

        int max = 0;
        int[] res = new int[k];

        for (int i = 0; i <= k && i <= nums1.length; i++) {
            int other = k - i;
            if (other <= nums2.length) {
                int[] first = getNum(nums1, i, cache1);
                int[] second = getNum(nums2, other, cahce2);
                int[] curRes = merge(first, second);
                if(isValid(res,curRes)){
                    res = curRes;
                }
            }
        }

        return res;
    }

    private boolean isValid(int[] res, int[] curRes) {
        for (int i = 0; i < res.length; i++) {
            if(res[i] < curRes[i])
                return true;
            else if(res[i] > curRes[i])
                return false;
        }
        return true;
    }



    private int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (index1 < first.length && index2 < second.length) {
            if (first[index1] > second[index2]) {
                res[i++] = first[index1++];
            } else if(first[index1] < second[index2])
                res[i++] = second[index2++];
            else{
                res[i++] = isNextIndex1(first, second, index1, index2) ? first[index1++] : second[index2++];
            }
        }

        while (index1 < first.length)
            res[i++] = first[index1++];

        while (index2 < second.length)
            res[i++] = second[index2++];

        return res;
    }

    private boolean isNextIndex1(int[] first, int[] second, int index1, int index2) {
        while (index1 < first.length && index2 < second.length){
            if(first[index1] > second[index2])
                return true;
            else if(first[index1] < second[index2])
                return false;
            index1++;
            index2++;
        }
        if(index1 == first.length)
            return false;
        if(index2 == second.length)
            return true;
        return false;
    }

    private int[] getNum(int[] nums, int target, int[][] cahce) {
        int[] res = new int[target];
        int left = 0;
        int right = nums.length - target;
        for (int i = 0; i < target; i++) {
            int index = cahce[left][right];
            res[i] = nums[index];
            left = index + 1;
            right = right + 1;
        }
        return res;
    }

    public int[][] getDP(int[] nums) {
        int[][] cache1 = new int[nums.length][nums.length];
        for (int i = 0; i < cache1.length; i++) {
            cache1[i][i] = i;
            if (i < cache1.length - 1)
                cache1[i][i + 1] = nums[i] >= nums[i + 1] ? i : i + 1;
        }

        for (int i = cache1.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < cache1.length; j++) {
                int index = nums[i] >= nums[j] ? i : j;
                if(nums[cache1[i + 1][j - 1]] > nums[index]){
                    index = cache1[i + 1][j - 1];
                }else if(nums[cache1[i + 1][j - 1]] == nums[index]){
                    index = cache1[i + 1][j - 1] >= index ? index : cache1[i + 1][j - 1];
                }
                cache1[i][j] = index;
            }
        }
        return cache1;
    }
}
