// import java.util.StringBuilder;
import java.util.List;
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                ans.add(sb.toString());
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }
        return ans;
    }
}