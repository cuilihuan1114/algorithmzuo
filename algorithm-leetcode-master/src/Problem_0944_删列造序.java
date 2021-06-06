
/**
 * @author cuilihuan
 * @data 2021/5/28 21:47
 */
public class Problem_0944_删列造序 {
    public int minDeletionSize(String[] strs) {
        if(strs == null || strs.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < strs[0].length(); i++) { // 列
            for (int j = 1; j < strs.length; j++) { // 行
                if(strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}
