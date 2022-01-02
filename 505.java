// without comparator =====================================================================
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int n = maze.length, m = maze[0].length, sr = start[0], sc = start[1], er = dest[0], ec = dest[1];
        PriorityQueue<int[]> que = new PriorityQueue<>((int[] a, int[] b)->{
            return a[2] - b[2];
        });
        que.add(new int[]{sr, sc, 0});
        int[][] dis = new int[n][m];
        dis[sr][sc] = 0;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] d: dis) Arrays.fill(d, (int)1e8);
        while (que.size() > 0) {
            int[] rem = que.remove();
            int i = rem[0], j = rem[1], len = rem[2];
            for (int[] d: dir) {
                int x = i, y = j, l = len;
                while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    l++;
                }
                x -= d[0];
                y -= d[1];
                --l;
                if (l < dis[x][y]) {
                    dis[x][y] = l;
                    que.add(new int[]{x, y, l});
                }
            }
        }
        return dis[er][ec] == (int)1e8 ? -1 : dis[er][ec];
    }
}

// with comparator =====================================================================
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
