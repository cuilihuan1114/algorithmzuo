/**
 * @author cuilihuan
 * @data 2020/12/2 18:16
 */
public class Problem_0048_旋转图像 {

    public static void main(String[] args) {
        new Problem_0048_旋转图像().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    //只需要定位两个坐标
    public void rotate(int[][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        while (x1 < x2){
            doRoate(matrix, x1++, y1++, x2--, y2--);
        }
    }

    //注意每一圈的交接位置
    private void doRoate(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < x2 - x1; i++) {
            int temp = matrix[x1][y1+i];
            matrix[x1][y1 + i] = matrix[x2-i][y1];
            matrix[x2-i][y1] = matrix[x2][y2 - i];
            matrix[x2][y2 - i] = matrix[x1 + i][y2];
            matrix[x1 + i][y2] = temp;
        }
    }

}
