// 3 iteration method ==============================================
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        return bfs(lca, p) + bfs(lca, q);
    }
    
    public TreeNode LCA(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) return node;
        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);
        if (left != null & right != null) return node;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        return null;
    }
    
    public int bfs(TreeNode node, int val) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(node);
        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode rem = que.poll();
                if (rem.val == val) return level;
                if (rem.left != null) que.add(rem.left);
                if (rem.right != null) que.add(rem.right);
            }
            level++;
        }
        return -1;
    }
}
// sinle iteration method ==============================================
// yet to be completed
