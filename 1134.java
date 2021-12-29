class Solution {
    public boolean isArmstrong(int n) {
        int count = 0;
        int temp = n;
        while (temp != 0) {
          count++;
          temp /= 10;
        }
        int ans = 0;
        int t = n;
        while (n != 0) {
          ans += Math.pow(n % 10, count);
          n /= 10;
        }
        return (ans == t);
    }
}
