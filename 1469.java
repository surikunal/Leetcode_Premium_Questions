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
    // recursive
    public void count(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        if (node.left != null && node.right == null) ans.add(node.left.val);
        if (node.right != null && node.left == null) ans.add(node.right.val);
        count(node.left, ans);
        count(node.right, ans);
    }
    
    // iterative
    public void count1(TreeNode root, List<Integer> ans) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null && node.right != null) {
                que.add(node.left);
                que.add(node.right);
            } else if (node.left != null) {
                que.add(node.left);
                ans.add(node.left.val);
            } else if (node.right != null) {
                que.add(node.right);
                ans.add(node.right.val);
            }
        }
    }
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            ans.add(0);
            return ans;
        }
        // count(root, ans);
        count1(root, ans);
        return ans;
    }
}
