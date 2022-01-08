class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i: sticks) pq.offer(i);
        int ans = 0;
        while (pq.size() != 1) {
            int a = pq.poll(), b = pq.poll();
            int sum = a + b;
            pq.add(sum);
            ans += sum;
        }
        return ans;
    }
}
