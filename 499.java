class Solution {
    public class point implements Comparable<point> {
        int x;
        int y;
        int dis;
        String path;
        point(int x, int y, int dis, String path) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.path = path;
        }
        public int compareTo(point o) {
            if (this.dis != o.dis) return this.dis - o.dis;
            return this.path.compareTo(o.path);
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length, m = maze[0].length, sr = ball[0], sc = ball[1], er = hole[0], ec = hole[1];
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        String[] path = {"l", "d", "r", "u"};
        PriorityQueue<point> que = new PriorityQueue<>();
        que.add(new point(sr, sc, 0, ""));
        boolean[][] vis = new boolean[n][m];
        while (que.size() != 0) {
            point rem = que.poll();
            int i = rem.x, j = rem.y, len = rem.dis; 
            if (i == er && j == ec) return rem.path;
            if (!vis[i][j]) {
                vis[i][j] = true;
                for (int d = 0; d < dir.length; ++d) {
                    int x = i, y = j, l = len;
                    while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0 && (x != er || y != ec)) {
                        x += dir[d][0];
                        y += dir[d][1];
                        l++;
                    }
                    if (x != er || y != ec) {
                        x -= dir[d][0];
                        y -= dir[d][1];
                        l--;
                    }
                    if (!vis[x][y])
                        que.add(new point(x, y, l, rem.path + path[d]));
                }
            }
        }
        return "impossible";
    }
}
