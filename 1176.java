public class Main {
    public static int dietPlanPerformance(int[] arr, int k, int lower, int upper) {
        int i = 0, ans = 0, count = 0;
        while (i < arr.length) {
            if (i % k == 0) {
                ans = arr[i];
                if (ans < lower) count--;
                else if (ans > upper) count++;
            } else {
                ans += arr[i];
            }
            i++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] calories = {6,5,0,0};
        int k = 2, lower = 1, upper = 5;
        int ans = dietPlanPerformance(calories, k, lower, upper);
        System.out.println(ans);
    }
}
