class Solution {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i == A[i])
                return i;
        }
        return -1;
    }
}

//========================================

class Solution {
    public int fixedPoint(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < mid) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return arr[i] == i ? i : -1;
    }
}
