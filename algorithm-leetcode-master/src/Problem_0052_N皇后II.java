/**
 * @author cuilihuan
 * @data 2020/12/2 21:11
 */
public class Problem_0052_N皇后II {
    public static void main(String[] args) {
        System.out.println(new Problem_0052_N皇后II().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        int[] his = new int[n];
        return process(0,his,n);
    }

    private int process(int cur,int[] his,int n) {
        if (cur == n)
            return 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(isValid(his,cur,i)){
                his[cur] = i;
                sum += process(cur + 1, his,n);
            }
        }
        return sum;
    }

    private boolean isValid(int[] his, int len, int cur) {
        for (int i = 0; i < len; i++) {
            if(his[i] == cur || (Math.abs(i-len) == Math.abs(his[i] - cur)))
                return false;
        }
        return true;
    }
    
}
