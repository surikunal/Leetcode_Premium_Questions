class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); ++i) {
            int c = keyboard.charAt(i);
            map[c - 'a'] = i;
        }
        int prev = 0;
        int ans = 0;
        for (int i = 0; i < word.length(); ++i) {
            ans += Math.abs(map[word.charAt(i) - 'a'] - prev);
            prev = map[word.charAt(i) - 'a'];
        }
        return ans;
    }
}
