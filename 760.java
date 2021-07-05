import java.util.HashMap;
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            map.put(A[i], i);
        }
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; ++i) {
            ans[i] = map.get(B[i]);            
        }
        return ans;
    }
}