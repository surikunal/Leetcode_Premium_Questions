class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> ans = new ArrayList<Integer>();
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int n1 = arr1[i], n2 = arr2[j], n3 = arr3[k];
            if (n1 == n2 && n2 == n3) {
                ans.add(n1);
                i++;
                j++;
                k++;
                System.out.print(n1 + " ");
            } else {
                if (n1 < n2 || n1 < n3) i++;
                if (n2 < n1 || n2 < n3) j++;
                if (n3 < n1 || n3 < n2) k++;
            }
        }
        return ans;
    }
}
