class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] f = new int[101];
        List<Integer> ans = new ArrayList<>();
        for (int[] arr: arrays)
            for (int i: arr)
                if (++f[i] == arrays.length)
                    ans.add(i);
        return ans;
    }
}
