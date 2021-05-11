
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cuilihuan
 * @data 2021/5/10 17:15
 */
public class Problem_0826_安排工作以达到最大收益 {


    public static void main(String[] args) {
        System.out.println(new Problem_0826_安排工作以达到最大收益().maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
    }

    class Info {
        int difficutlty;
        int profit;

        public Info(int difficutlty, int profit) {
            this.difficutlty = difficutlty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (worker == null || worker.length == 0)
            return 0;
        Info[] info = new Info[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            info[i] = new Info(difficulty[i], profit[i]);
        }

        Arrays.sort(info, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.difficutlty - o2.difficutlty;
            }
        });

        Arrays.sort(worker);

        int ans = 0;
        int i = 0;
        int curMax = 0;
        for(Integer work : worker){
            while (i < info.length && work >= info[i].difficutlty ){
                curMax = Math.max(curMax, info[i].profit);
                i++;
            }
            ans += curMax;
        }
        return ans;
    }
}
