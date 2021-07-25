public class 370 {
    public int[] getModifiedArray(int n, int[][] arr) {
        int[] ans = new int[n];
        for (int[] ar: arr) {
            int i = ar[0], j = ar[1], val = ar[2];
            ar[i] += val;
            if (j + 1 < n)
                ar[j + 1] -= val;
        }
        for (int i = 1; i < n; ++i) {
            ans[i] = ans[i] + ans[i - 1];
        }
        return ans;
    }
} 