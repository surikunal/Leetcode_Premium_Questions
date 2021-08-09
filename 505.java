import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length, sr = start[0], sc = start[1], er = destination[0], ec = destination[1];

        class pair implements Comparable<pair> {
            int r, c, dis;

            pair(int r, int c, int dis) {
                this.r = r;
                this.c = c;
                this.dis = dis;
            }

            public int compareTo(pair o) {
                return this.dis - o.dis;
            }
        }

        PriorityQueue<pair> que = new PriorityQueue<>();
        int[][] distance = new int[n][m];
        for (int[] d : distance) {
            Arrays.fill(d, (int) 1e8);
        }

        pair src = new pair(sr, sc, 0);
        que.add(src);
        distance[sr][sc] = 0;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (que.size() != 0) {
            pair p = que.remove();
            for (int[] d : dir) {
                int r = p.r, c = p.c, l = p.dis;
                while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                    r += d[0];
                    c += d[1];
                    l++;
                }
                r -= d[0];
                c -= d[1];
                --l;

                if (l >= distance[r][c])
                    continue;

                que.add(new pair(r, c, l));
                distance[r][c] = l;
            }
        }
        return distance[er][ec] != (int) 1e8 ? distance[er][ec] : -1;
    }
}