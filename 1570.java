public class 1570 {
    public int dotProduct(int[] a, int[] b) {
        if (a.length != b.length) return -1;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i] * b[i];
        }
        return ans;
    }
}
