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
