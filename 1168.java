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
