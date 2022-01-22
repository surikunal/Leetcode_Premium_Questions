// Prims alg0 =========================================================
class Solution {
    public int minimumCost(int n, int[][] arr) {
        if (arr == null || arr.length == 0) return -1;
        // graph construction
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] ar: arr) {
            int u = ar[0], v = ar[1], wt = ar[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, wt});
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new int[]{u, wt});
        }
        // prims algo
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> vis = new HashSet<>();
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; ++i) {
                int[] rem = pq.poll();
                int nbr = rem[0], wt = rem[1];
                if (!vis.contains(nbr)) {
                    vis.add(nbr);
                    cost += wt;
                    for (int[] nbrs: graph.get(nbr)) pq.add(nbrs);
                }
            }
        }
        if (vis.size() < n) return -1;
        return cost;
    }
}

// Kruskal algo =========================================================
class Solution {
    public int minimumCost(int n, int[][] connections) {
        int[] par = new int[n + 1];
        int N = n, cost = 0;
        for (int i = 0; i <= n; ++i) par[i] = i;
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for (int[] c: connections) {
            int x = c[0], y = c[1], wt = c[2];
            int par1 = find(x, par);
            int par2 = find(y, par);
            if (par1 != par2) {
                cost += wt;
                if (par1 != par2) {
                    par[par1] = par2;
                    N--;
                }
            }
        }
        return N == 1 ? cost : -1;
    }
    
    public int find(int i, int[] par) {
        if (i == par[i]) return i;
        return par[i] = find(par[i], par);
    }
}
