// without making graph =========================================

class Solution {
    public int countComponents(int n, int[][] edges) {
        // union find
        int count = n;
        int[] par = new int[n];
        for (int i = 0; i < n; ++i) par[i] = i;
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int par1 = find(u, par);
            int par2 = find(v, par);
            if (par1 != par2) {
                par[par1] = par2;
                count--;
            }
        }
        return count;
    }
    public int find(int i, int[] par) {
        if (i == par[i]) return i;
        return par[i] = find(par[i], par);
    }
}

// with making graph =========================================

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int[] e: edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (vis[i] == false) {
                count++;
                dfs(graph, i, vis);
            }
        }
        return count;
    }
    
    public void dfs(List<List<Integer>> graph, int i, boolean[] vis) {
        vis[i] = true;
        for (int nbr: graph.get(i)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, vis);
            }
        }
    }
}
