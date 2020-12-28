/**
 * @author cuilihuan
 * @data 2020/11/23 22:13
 */
public class Problem_0037_解数独 {
    public void solveSudoku(char[][] board) {
        int[] row = new int[10];
        int[] col = new int[10];
        int[] gird = new int[10];
        initMap(board, row, col, gird);
        process(board, row, col, gird, 0, 0);
    }

    private boolean process(char[][] board, int[] row, int[] col, int[] gird, int i, int j) {
        if (i == 9)
            return true;
        int nextI = j == 8 ? i + 1 : i;
        int nextJ = j == 8 ? 0 : j + 1;
        if (board[i][j] != '.') {
            return process(board, row, col, gird, nextI, nextJ);
        } else {
            for (int k = 1; k < 10; k++) {
                int pos = (i / 3) * 3 + j / 3;
                //注意这里是用continue 而不是return false 因为这个k不符合条件  还可以适配后面的几个 如果直接return false的话 整个都不会走了
                if (((row[i] >> k) & 1) == 1 || ((col[j] >> k) & 1) == 1 || ((gird[pos] >> k) & 1) == 1)
                    continue;
                row[i] = row[i] | (1 << k);
                col[j] = col[j] | (1 << k);
                gird[pos] = gird[pos] | (1 << k);
                board[i][j] = (char) (k + '0');
                if (process(board, row, col, gird, nextI, nextJ)) {
                    return true;
                }
                int old = ~(1 << k);
                row[i] = row[i] & old;
                col[j] = col[j] & old;
                gird[pos] = gird[pos] & old;
                board[i][j] = '.';
            }
            return false;
        }
    }

    private void initMap(char[][] board, int[] row, int[] col, int[] gird) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int pos = (i / 3) * 3 + j / 3;
                    row[i] = row[i] | (1 << num);
                    col[j] = col[j] | (1 << num);
                    gird[pos] = gird[pos] | (1 << num);
                }
            }
        }
    }
}
