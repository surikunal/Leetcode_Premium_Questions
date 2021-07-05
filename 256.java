public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        for (int i = 1; i < n; ++i) {
            costs[i][0] += Math.min(costs[i][1], costs[i][2]);
            costs[i][1] += Math.min(costs[i][0], costs[i][2]);
            costs[i][2] += Math.min(costs[i][1], costs[i][0]);
        }
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
}