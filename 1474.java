/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head, lastMNode = head;
        while (curr != null) {
            int tempM = m;
            while (curr != null && tempM-- != 0) {
                lastMNode = curr;
                curr = curr.next;
            }
            int tempN = n;
            while (curr != null && tempN-- != 0) {
                curr = curr.next;
            }
            tempM.next = curr;
        }
        return head;
    }
}