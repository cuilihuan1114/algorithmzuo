/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0289_生命游戏 {
    public void gameOfLife(int[][] board) {
        boolean[][] life = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                life[i][j] = process(board,i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = (life[i][j] ? 1 : 0);
            }
        }
    }

    private boolean process(int[][] board, int i, int j) {
        int num = 0;
        num += ok(board, i + 1, j) ? 1 : 0;
        num += ok(board, i - 1, j) ? 1 : 0;
        num += ok(board, i, j + 1) ? 1 : 0;
        num += ok(board, i, j - 1) ? 1 : 0;
        num += ok(board, i + 1, j + 1) ? 1 : 0;
        num += ok(board, i - 1, j - 1) ? 1 : 0;
        num += ok(board, i + 1, j - 1) ? 1 : 0;
        num += ok(board, i - 1, j + 1) ? 1 : 0;
        if(board[i][j] == 1 && (num < 2 || num > 3))
            return false;
        if (board[i][j] == 1 && (num == 2 || num == 3))
            return true;
        if(board[i][j] == 0 && num == 3)
            return true;
        return board[i][j] == 1;
    }

    public boolean ok(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 1;
    }
}
