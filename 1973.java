/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int helper(TreeNode node, int[] count) {
        if (node == null) return 0;
        int l = helper(node.left, count);
        int r = helper(node.right, count);
        if ((l + r) == node.val) count[0]++;
        return l + r + node.val;
    }
    public int equalToDescendants(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
}
