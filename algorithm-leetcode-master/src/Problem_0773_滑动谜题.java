
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/4/17 21:29
 */
public class Problem_0773_滑动谜题 {

    public static void main(String[] args) {
        System.out.println(new Problem_0773_滑动谜题().slidingPuzzle1(new int[][]{{3, 2, 4}, {1, 5, 0}}));
    }

    class Info {
        int x;
        int y;
        String s;
        int[][] cur = new int[2][3];

        public Info(int x, int y, String s, int[][] cur) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.cur = cur;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    public int slidingPuzzle1(int[][] board) {
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new ArrayDeque();
        Node start = new Node(board, sr, sc, 0);
        queue.add(start);

        Set<String> seen = new HashSet();
        seen.add(start.boardstring);

        String target = Arrays.deepToString(new int[][]{{1, 2, 3}, {4, 5, 0}});

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.boardstring.equals(target))
                return node.depth;

            for (int[] di : directions) {
                int nei_r = di[0] + node.zero_r;
                int nei_c = di[1] + node.zero_c;

                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row : node.board)
                    newboard[t++] = row.clone();
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;

                Node nei = new Node(newboard, nei_r, nei_c, node.depth + 1);
                if (seen.contains(nei.boardstring))
                    continue;
                queue.add(nei);
                seen.add(nei.boardstring);
            }
        }

        return -1;
    }


    class Node {
        int[][] board;
        String boardstring;
        int zero_r;
        int zero_c;
        int depth;

        Node(int[][] B, int r, int c, int d) {
            board = B;
            boardstring = Arrays.deepToString(board);
            zero_r = r;
            zero_c = c;
            depth = d;
        }
    }


    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        Queue<Info> queue = new LinkedList<>();
        String res = getString(board);
        if (res.equals(target))
            return 0;
        getFirst(queue, board, res);
        HashSet<String> set = new HashSet<>();
        set.add(res);
        int count = 0;
        while (!queue.isEmpty()) {
            Queue<Info> mid = new LinkedList<>();
            while (!queue.isEmpty()) {
                Info poll = queue.poll();
                int[][] midBoard = poll.cur;
                int[][] gen;
                String s = "";
                if (poll.x == 0 && poll.y <= 1) {
                    gen = getArray(midBoard, poll.x, poll.y, poll.x, poll.y + 1);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x, poll.y + 1, s, gen));
                        set.add(s);
                    }

                    gen = getArray(midBoard, poll.x, poll.y, poll.x + 1, poll.y);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x + 1, poll.y, s, gen));
                        set.add(s);
                    }
                }
                if (poll.x == 0 && poll.y == 2) {
                    gen = getArray(midBoard, poll.x, poll.y, poll.x, poll.y - 1);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x, poll.y - 1, s, gen));
                        set.add(s);
                    }
                    gen = getArray(midBoard, poll.x, poll.y, poll.x + 1, poll.y);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x + 1, poll.y, s, gen));
                        set.add(s);
                    }
                }

                if (poll.x == 1 && poll.y < 2) {
                    gen = getArray(midBoard, poll.x, poll.y, poll.x - 1, poll.y);
                    s = getString(gen);

                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x - 1, poll.y, s, gen));
                        set.add(s);
                    }
                    gen = getArray(midBoard, poll.x, poll.y, poll.x, poll.y + 1);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        set.add(s);
                        mid.add(new Info(poll.x, poll.y + 1, s, gen));
                    }
                }

                if (poll.x == 1 && poll.y == 2) {
                    gen = getArray(midBoard, poll.x, poll.y, poll.x, poll.y - 1);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x, poll.y - 1, s, gen));
                        set.add(s);
                    }
                    gen = getArray(midBoard, poll.x, poll.y, poll.x - 1, poll.y);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        set.add(s);
                        mid.add(new Info(poll.x - 1, poll.y, s, gen));
                    }
                }

                if (poll.y == 1) {
                    gen = getArray(midBoard, poll.x, poll.y, poll.x, poll.y - 1);
                    s = getString(gen);
                    if (s.equals(target))
                        return count + 1;
                    if (!set.contains(s)) {
                        mid.add(new Info(poll.x, poll.y - 1, s, gen));
                        set.add(s);
                    }
                }
            }
            count++;
            queue = mid;
        }
        return -1;
    }

    private void getFirst(Queue<Info> queue, int[][] board, String res) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        queue.add(new Info(x, y, res, board));
    }

    private int[][] getArray(int[][] midBoard, int x, int y, int targetX, int targetY) {
        int[][] res = new int[midBoard.length][midBoard[0].length];
        for (int i = 0; i < midBoard.length; i++) {
            for (int j = 0; j < midBoard[0].length; j++) {
                res[i][j] = midBoard[i][j];
            }
        }

        res[x][y] = res[targetX][targetY];
        res[targetX][targetY] = 0;
        return res;
    }

    private String getString(int[][] board) {
        String res = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                res = res + board[i][j];
            }
        }
        return res;
    }

}
