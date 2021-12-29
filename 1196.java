class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0, count = 0;
        for (int i: weight) {
            sum += i;
            if (sum > 5000) return count;
            count++;
        }
        return count;
    }
}

//===========================================

class Solution {
    public int maxNumberOfApples(int[] arr) {
        // count sort
        int mini = arr[0], maxi = arr[0];
        for (int i: arr) {
            mini = Math.min(i, mini);
            maxi = Math.max(i, maxi);
        }
        int[] freq = new int[maxi - mini + 1];
        for (int i = 0; i < arr.length; ++i) {
            int idx = arr[i] - mini;
            freq[idx]++;
        }
        for (int i = 1; i < freq.length; ++i) {
            freq[i] = freq[i] + freq[i - 1];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; --i) {
            int val = arr[i];
            int pos = freq[val - mini];
            int idx = pos - 1;
            ans[idx] = val;
            freq[val - mini]--;
        }
        int sum = 0, count = 0;
        for (int i : ans) {
            sum += i;
            if (sum > 5000) return count;
            count++;
        }
        return count;
    }
}
