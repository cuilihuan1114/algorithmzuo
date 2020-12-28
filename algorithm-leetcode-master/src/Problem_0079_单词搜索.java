/**
 * @author cuilihuan
 * @data 2020/12/18 9:53
 */
public class Problem_0079_单词搜索 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag |= process(board, word, i, j, 0);
            }
        }
        return flag;
    }

    public boolean process(char[][] board, String word, int x, int y, int index) {
        if (index == word.length())
            return true;
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0)
            return false;
        if (board[x][y] != word.charAt(index))
            return false;
        char record = board[x][y];
        board[x][y] = '0';
        boolean flag = process(board, word, x + 1, y, index + 1) || process(board, word, x, y + 1, index + 1)
                || process(board, word, x - 1, y, index + 1) || process(board, word, x, y - 1, index + 1);
        board[x][y] = record;
        return flag;
    }

}
