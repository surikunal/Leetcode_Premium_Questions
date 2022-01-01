class Solution {
    private int findPar(int i, int[] par) {
        if (par[i] == i) return i;
        return par[i] = findPar(par[i], par);
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] par = new int[n];
        for (int i = 0; i < n; ++i) {
            par[i] = i;
        }
        for (int[] i: edges) {
            int u = findPar(i[0], par);
            int v = findPar(i[1], par);
            if (u != v) {
                par[u] = v;
            } else {
                return false;
            }
        }
        return true;
    }
}
