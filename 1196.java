import java.util.Arrays;
class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        for (int val: arr) {
            sum += val;
            count++;
            if (sum > 5000) return count;
        }
        return 0;
    }
}