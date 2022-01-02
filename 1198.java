
// simply counting the freq is enough
class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < mat[0].length; ++j) {
            for (int i = 0; i < mat.length; ++i) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
                if (map.get(mat[i][j]) == mat.length) {
                    return mat[i][j];
                }
            }
        }
        return -1;
    }
}
