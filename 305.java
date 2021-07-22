public class 305 {
    private int findPar(int i, int[] par) {
        if (i == par[i]) return i;
        return par[i] = findPar(par[i], par);
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[] par = new int[m * n];
        Arrays.fill(par, -1);
        int count = 0;
        for (int[] p: positions) {
            int i = p[0], j = p[1];
            if (par[i * m + j] == -1) {
                count++;
                par[i * m + j] = i * m + j;
                int par1 = findPar(i * m + j, par);
                for (int d = 0; d < dir.length; ++d) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] != -1) {
                        int par2 = findPar(r * m + c, par);
                        if (par1 != par2) {
                            par[par2] = par1;   // must make p2 as global parent
                            count--;
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
