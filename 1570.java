class SparseVector {
    int[] arr;
    SparseVector(int[] nums) {
        arr = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
            ans += arr[i] * vec.arr[i];
        return ans;
    }
}

//==================================================

class SparseVector {
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != 0) map.put(i, nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for (int i: this.map.keySet())
            if (vec.map.containsKey(i))
                ans += this.map.get(i) * vec.map.get(i);
        return ans;
    }
}
