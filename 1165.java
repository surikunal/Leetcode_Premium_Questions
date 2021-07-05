public class 1165 {
    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); ++i) {
            int c = keyboard.charAt(i);
            map[c - 'a'] = i;
        }

        int ans = map[word.charAt(0)];
        for (int i = 1; i < word.length(); ++i) {
            ans += Math.abs(map[word.charAt(i)] - prev);
            prev = map[word.charAt(i)];
        }
        return ans;
    }
}
