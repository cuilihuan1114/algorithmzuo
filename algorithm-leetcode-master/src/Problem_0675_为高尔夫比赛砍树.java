
import java.util.*;

/**
     * @author cuilihuan
     * @data 2021/3/27 19:28
     */
    public  class Problem_0675_为高尔夫比赛砍树 {

        public static void main(String[] args) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(3);
            list1.add(2);
            list.add(list1);

            List<Integer> list2 = new ArrayList<>();
            list2.add(0);
            list2.add(0);
            list2.add(4);
            list.add(list2);

            List<Integer> list3 = new ArrayList<>();
            list3.add(7);
            list3.add(6);
            list3.add(5);
            list.add(list3);
            System.out.println(new Problem_0675_为高尔夫比赛砍树().cutOffTree(list));
        }


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        public int cutOffTree(List<List<Integer>> forest) {
            List<int[]> trees = new ArrayList();
            for (int r = 0; r < forest.size(); ++r) {
                for (int c = 0; c < forest.get(0).size(); ++c) {
                    int v = forest.get(r).get(c);
                    if (v > 1) trees.add(new int[]{v, r, c});
                }
            }

            Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
            int row = forest.size();
            int vec = forest.get(0).size();
            int ans = 0, sr = 0, sc = 0;
            for (int[] tree : trees) {
                int d = dfs(forest, row, vec, sr, sc, tree[1], tree[2]);
                if (d == Integer.MAX_VALUE) return -1;
                ans += d;
                sr = tree[1];
                sc = tree[2];
            }
            return ans;
        }

        public int dfs(List<List<Integer>> forest, int row, int vec, int x, int y, int tr, int tc) {

            if (x == tr && y == tc)
                return 0;

            int max = Integer.MAX_VALUE;
            int cur = forest.get(x).get(y);

            int p1 = Integer.MAX_VALUE;
            if (x + 1 < row) {
                int next = forest.get(x + 1).get(y);
                if (next > 0) {
                    forest.get(x + 1).set(y, 0);
                    p1 = dfs(forest, row, vec, x + 1, y, tr, tc);
                    p1 = (p1 == Integer.MAX_VALUE ? p1 : p1 + 1);
                    forest.get(x + 1).set(y, next);
                }
            }

            max = Math.min(max, p1);

            p1 = Integer.MAX_VALUE;
            if (x - 1 >= 0) {
                int next = forest.get(x - 1).get(y);
                if (next > 0) {
                    forest.get(x - 1).set(y, 0);
                    p1 = dfs(forest, row, vec, x - 1, y, tr, tc);
                    p1 = (p1 == Integer.MAX_VALUE ? p1 : p1 + 1);
                    forest.get(x - 1).set(y, next);
                }
            }
            max = Math.min(max, p1);


            if (y + 1 < vec) {
                int next = forest.get(x).get(y + 1);
                if (next > 0) {
                    forest.get(x).set(y + 1, 0);
                    p1 = dfs(forest, row, vec, x, y + 1, tr, tc);
                    p1 = (p1 == Integer.MAX_VALUE ? p1 : p1 + 1);
                    forest.get(x).set(y + 1, next);
                }
            }
            max = Math.min(max, p1);

            if (y - 1 >= 0) {
                int next = forest.get(x).get(y - 1);
                if (next > 0) {
                    forest.get(x).set(y - 1, 0);
                    p1 = dfs(forest, row, vec, x, y - 1, tr, tc);
                    p1 = (p1 == Integer.MAX_VALUE ? p1 : p1 + 1);
                    forest.get(x).set(y - 1, next);
                }
            }

            max = Math.min(max, p1);

            return max;
        }


        public int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
            int R = forest.size(), C = forest.get(0).size();
            Queue<int[]> queue = new LinkedList();
            queue.add(new int[]{sr, sc, 0});
            boolean[][] seen = new boolean[R][C];
            seen[sr][sc] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == tr && cur[1] == tc) return cur[2];
                for (int di = 0; di < 4; ++di) {
                    int r = cur[0] + dr[di];
                    int c = cur[1] + dc[di];
                    if (0 <= r && r < R && 0 <= c && c < C &&
                            !seen[r][c] && forest.get(r).get(c) > 0) {
                        seen[r][c] = true;
                        queue.add(new int[]{r, c, cur[2] + 1});
                    }
                }
            }
            return -1;
        }


    }