/**
 * @author cuilihuan
 * @data 2020/11/23 20:43
 */
public class Problem_0036_有效的数独 {

    //位运优化
    public boolean isValidSudoku(char[][] board) {
        //用几个有限的变量来表示行的每个数字是否出现
        int[] row = new int[10];
        //用几个有限的变量来表示列的每个数字是否出现
        int[] col = new int[10];

        int[] grid = new int[10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                int pos = (i / 3) * 3 + j / 3;
                if (((row[i] >> num) & 1) == 1 || ((col[j] >> num) & 1) == 1 || ((grid[pos] >> num) & 1) == 1)
                    return false;

                row[i] = row[i] | (1 << num);
                col[j] = col[j] | (1 << num);
                grid[pos] = grid[pos] | (1 << num);
            }
        }

        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];

        boolean[][] grid = new boolean[9][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int pos = (i / 3) * 3 + j / 3;
                int num = board[i][j] - '0';
                if (row[i][num] || col[j][num] || grid[pos][num])
                    return false;
                row[i][num] = true;
                col[j][num] = true;
                grid[pos][num] = true;
            }
        }
        return true;
    }
}
