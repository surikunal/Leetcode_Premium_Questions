import java.util.HashSet;
public class Solution {
    public HashSet<String> map = new HashSet<>();
    // String[] dir = {"R","D","L","U"};
    public void dfs(int i, int j, int[][] grid, StringBuilder sb) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        
        sb.append("D");
        dfs(i + 1, j, grid, sb);
        sb.append("B");
        
        sb.append("R");
        dfs(i, j + 1, grid, sb);
        sb.append("B");
        
        sb.append("U");
        dfs(i - 1, j, grid, sb);
        sb.append("B");

        sb.append("L");
        dfs(i, j - 1, grid, sb);
        sb.append("B");
    }
    public int numberofDistinctIslands(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                StringBuilder sb = new StringBuilder();
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, sb);
                    map.add(sb.toString());
                    // System.out.print(sb.toString() + " ");
                }
            }
        }
        return map.size();
    }
}