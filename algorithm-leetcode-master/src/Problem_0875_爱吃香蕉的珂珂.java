
/**
 * @author cuilihuan
 * @data 2021/5/11 16:56
 */
public class Problem_0875_爱吃香蕉的珂珂 {

    // 一看它给的数据量是O(N^4) 对于这种测试数据一般时间复杂度为O(nlgn) 所以一般考虑到排序和二分法
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1000000000;
        while (start <= end){
            int mid = (start + end) / 2;
            if(!isPos(piles,h,mid)){
                start = mid + 1;
            }else
                end = mid - 1;
        }
        return start;

    }

    private boolean isPos(int[] piles, int h, int mid) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += piles[i] / mid + (piles[i] % mid == 0 ? 0 : 1);
        }

        return count <= h;
    }
}
