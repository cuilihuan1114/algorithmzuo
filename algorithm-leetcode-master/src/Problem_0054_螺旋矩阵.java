import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/3 8:51
 */
public class Problem_0054_螺旋矩阵 {
    public static void main(String[] args) {
        System.out.println(new Problem_0054_螺旋矩阵().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        //需要注意的是它是一个长方形 所以需要注意x1 x2 和 y1 y2的条件都需要满足
        while (x1 <= x2 && y1 <= y2){
            printNums(list,matrix, x1++, y1++, x2--, y2--);
        }
        return list;
    }

    private void printNums(List<Integer> list, int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = y1; i <=y2 ; i++) {
            list.add(matrix[x1][i]);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            list.add(matrix[i][y2]);
        }
        //后面一个判断表示的是如果在一行 就不打印了 因为之前第一个已经打印过了
        for (int i = y2 - 1; i >=y1 && x1 != x2; i--) {
            list.add(matrix[x2][i]);
        }
        //后面一个判断表示的是如果只有一行 就不打印了 因为之前第二个已经打印过了
        for (int i = x2 - 1; i > x1 && y1 != y2; i--) {
            list.add(matrix[i][y1]);
        }

    }
}
