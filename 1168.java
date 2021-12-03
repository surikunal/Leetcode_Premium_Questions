// Using UNION FIND     =======================================================

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class 1168 {
    private static int findPar(int i, int[] par) {
        if (i == par[i]) return i;
        return par[i] = findPar(par[i], par);
    }
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] par = new int[n + 1];
        List<int[]> graph = new ArrayList<>();

        // made a new graph with an extra node 0
        for (int[] i: pipes) graph.add(i);
        for (int i = 0; i < n; ++i) {
            graph.add(new int[] {0, i + 1, wells[i]});
            par[i] = i;
        }
        par[n] = n;

        // sortint according to weights
        Collections.sort(graph, (a, b) -> {
            return a[2] - b[2];
        });

        // union find
        int ans = 0;
        for (int[] e: graph) {
            int u = e[0], v = e[1], w = e[2];
            int par1 = findPar(u, par);
            int par2 = findPar(v, par);
            if (par1 != par2) {
                par[par1] = par2;
                ans += w;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1,2,2};
        int[][] pipes = {{1,2,1},{2,3,1}};
        System.out.println(minCostToSupplyWater(n, wells, pipes));
    }
}


// Using PRIMS ALGORITHM    ================================================

class Solution {
    public class Pair implements Comparable<Pair> {
        int vtx;
        int wt;
        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
        
        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // graph construction
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i)
            graph.add(new ArrayList<>());
        // graph from pipes
        for (int i = 0; i < pipes.length; ++i) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }
        // graph from wells
        for (int i = 1; i <= n; ++i) {
            graph.get(0).add(new Pair(i, wells[i - 1]));
            graph.get(i).add(new Pair(0, wells[i - 1]));
        }
        
        // now prims algo using PQ
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        boolean[] vis = new boolean[n + 1];
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (vis[rem.vtx] == true) continue;
            
            ans += rem.wt;
            
            vis[rem.vtx] = true;
            ArrayList<Pair> nbrs = graph.get(rem.vtx);
            for (Pair nbr : nbrs) {
                if (vis[nbr.vtx] == false) {
                    pq.add(nbr);
                }
            }
        }
        return ans;
    }
}
