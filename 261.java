class Main {
    private int findPar(int i, int[] par) {
        if (par[i] == i) return i;
        return par[i] = findPar(par[i]);
    }
    public boolean validTree(int n, int[][] edges) {
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