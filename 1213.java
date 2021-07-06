import java.util.List;
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int num1 = arr1[i], num2 = arr2[j], num3 = arr3[k];
            if (num1 == num2 && num3 == num1) {
                ans.add(num1);
                i++;
                j++;
                k++;
            } else {
                int inc1 = 0, inc2 = 0, inc3 = 0;
                if (num1 < num2 || num1 < num3)
                    inc1 = 1;
                if (num2 < num1 || num2 < num3)
                    inc2 = 1;
                if (num3 < num1 || num3 < num1)
                    inc3 = 1;
                i += inc1;
                j += inc2;
                k += inc3;
            }
        }
        return ans;
    }
}