/**
 * @author cuilihuan
 * @data 2020/12/22 17:08
 */
public class Problem_0130_被围绕的区域 {

    public static void main(String[] args) {
        new Problem_0130_被围绕的区域().solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }

    //自己写的方法 有两个测试用例用不来 超出时间范围
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (flag[i][j] == 1 || flag[i][j] == -1)
                    continue;
                if (board[i][j] == 'O') {
                    if (process(board, flag, i, j))
                        run(board, flag, i, j, 1);
                    else
                        run(board, flag, i, j, -1);
                }
            }
        }
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                if (flag[i][j] == 1)
                    board[i][j] = 'X';
            }

        }
    }

    private void run(char[][] board, int[][] flag, int i, int j, int p) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        if (board[i][j] != 'O')
            return;
        if (flag[i][j] == 1 || flag[i][j] == -1)
            return;
        flag[i][j] = p;
        run(board, flag, i + 1, j, p);
        run(board, flag, i, j + 1, p);
        run(board, flag, i - 1, j, p);
        run(board, flag, i, j - 1, p);

    }

    private boolean process(char[][] board, int[][] flag, int i, int j) {
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            if (board[i][j] == 'X')
                return true;
            return false;
        }
        if (board[i][j] == 'X')
            return true;
        if (board[i][j] == '0')
            return true;
        if(flag[i][j] == 1 || flag[i][j] == -1)
            return flag[i][j] == 1;
        board[i][j] = '0';
        boolean p = process(board, flag, i + 1, j) && process(board, flag, i, j + 1) && process(board, flag, i - 1, j) && process(board, flag, i, j - 1);
        board[i][j] = 'O';
        return p;
    }
}
