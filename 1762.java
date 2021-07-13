class Solution {
    public int[] findBuildings(int[] arr) {
        int maxH = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (maxH < arr[i]) {
                maxH = arr[i];
                ans.add(0, i);
            }
        }
        int idx = 0;
        int[] res = new int[ans.size()];
        for (Integer i: ans)
            res[idx++] = i;
        return res;
    }
}