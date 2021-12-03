class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        int tm = m, tn = n;
        ListNode curr = head, h1 = head;
        while (curr != null) {
            int tempm = m;
            while (curr != null && tempm-- != 0) {
                h1 = curr;
                curr = curr.next;
            }
            int tempn = n;
            while (curr != null && tempn-- != 0) {
                curr = curr.next;
            }
            h1.next = curr;
        }
        return head;
    }
}
