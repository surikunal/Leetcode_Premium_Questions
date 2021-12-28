class Solution {
    public int findPar(int i, int[] par) {
        if (i == par[i]) return i;
        return par[i] = findPar(par[i], par);
    }
    public void union(int i, int j, int[] rank, int[] par) {
        if (rank[i] < rank[j]) {
            par[i] = j;
        } else if (rank[i] > rank[j]) {
            par[j] = i;
        } else {
            par[i] = j;
            rank[j]++;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        if (positions == null || positions.length == 0) return ans;
        int[] par = new int[n * m];
        int[] rank = new int[n * m];
        Arrays.fill(par, -1);
        Arrays.fill(rank, 1);
        int count = 0;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] position: positions) {
            int i = position[0], j = position[1];
            int idx = i * n + j;
            System.out.println(i + "->" + j);
            if (par[idx] != -1) {
                ans.add(count);
                continue;
            }
            count++;
            par[idx] = idx;
            // int par1 = findPar(idx, par);
            int par1 = idx;
            for (int[] d: dir) {
                int x = i + d[0], y = j + d[1];
                if (x >= 0 && y >= 0 && x < m && y < n && par[x * n + y] != -1) {
                    System.out.println(x + ", " + y);
                    int nbr = x * n + y;
                    int par2 = findPar(nbr, par);
                    if (par1 != par2) {
                        // union(par1, par2, rank, par);
                        par[par2] = par1;
                        count--;
                    }
                }
            }
            System.out.println();
            ans.add(count);
        }
        return ans;
    }
}
