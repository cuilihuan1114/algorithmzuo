import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/17 14:57
 */
public class Problem_0051_N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] rowPosition = new int[n];
        process(result, n, 0, rowPosition);
        return result;
    }

    public static void process(List<List<String>> result, int n, int row, int[] rowPosition) {
        if (row == n) {
            addResult(result, rowPosition);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(rowPosition, i,row)) {
                rowPosition[row] = i;
                process(result, n, row + 1, rowPosition);
            }
        }
    }

    private static boolean isValid(int[] rowPosition, int i,int row) {
        for (int j = 0; j < row; j++) {
            if(rowPosition[j] == i || Math.abs(rowPosition[j]-i)==Math.abs(j-row))
                return false;
        }
        return true;
    }

    private static void addResult(List<List<String>> result, int[] rowPosition) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < rowPosition.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < rowPosition.length; j++) {
                if (j != rowPosition[i])
                    s.append(".");
                else
                    s.append("Q");
            }
            list.add(s.toString());
        }
        result.add(list);
    }


}
