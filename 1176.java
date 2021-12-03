
// very poorly explained question of leetcode

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0, points = 0;
        for (int i = 0; i < calories.length; ++i) {
            sum += calories[i];
            if (i >= k - 1) {
                if (i > k - 1) sum -= calories[i - k];
                if (sum > upper) points++;
                else if (sum < lower) points--;
            }
        }
        return points;
    }
}
