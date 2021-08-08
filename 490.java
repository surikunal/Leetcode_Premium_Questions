
// as we need only true/false and no distace... so bfs se good idea
// but instead of simple bfs, we need to travel more than one step
import java.util.LinkedList;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int sr = start[0], sc = start[1], er = destination[0], ec = destination[1];
        que.addFirst(sr * m + sc);
        vis[sr][sc] = true;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int len = Math.max(n, m);
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.removeFirst();
                int i = idx / m;
                int j = idx % m;

                for (int[] d : dir) {
                    int fr = i, fc = j; // final row, final col
                    for (int rad = 1; rad < len; ++rad) {
                        int r = i + rad * d[0];
                        int c = j + rad * d[1];
                        if (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                            fr = r;
                            fc = c;
                        } else {
                            break;
                        }
                    }
                    if (vis[fr][fc])
                        continue;
                    vis[fr][fc] = true;
                    que.addLast(fr * m + fc);
                    if (fr == er && fc == ec) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // other way to write the same loop
    // better for direction traversal
    public boolean hasPath_(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int sr = start[0], sc = start[1], er = destination[0], ec = destination[1];
        que.addFirst(sr * m + sc);
        vis[sr][sc] = true;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int len = Math.max(n, m);
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.removeFirst();
                int i = idx / m;
                int j = idx % m;

                for (int[] d : dir) {
                    int r = i, c = j; // final row, final col

                    while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                        r += d[0];
                        c += d[1];
                    }

                    if (vis[r][c])
                        continue;
                    vis[r][c] = true;
                    que.addLast(r * m + c);
                    if (r == er && c == ec) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}