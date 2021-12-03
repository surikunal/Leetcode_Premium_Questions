import java.util.HashMap;
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i)
            map.put(nums2[i], i);
        int[] ans = new int[nums2.length];
        for (int i = 0; i < nums1.length; ++i)
            ans[i] = map.get(nums1[i]);
        return ans;
    }
}
