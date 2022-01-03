/**
 Importqant point to note here is we will travserse right node first 
 so that it will be already visited when we are checking for it
 */
class Solution {
    public TreeNode helper(TreeNode node, HashSet<Integer> map) {
        if (node == null) return null;
        if (node.right != null && map.contains(node.right.val)) return null;
        map.add(node.val);
        node.right = helper(node.right, map);
        node.left = helper(node.left, map);
        return node;
    }
    public TreeNode correctBinaryTree(TreeNode root) {
        return helper(root, new HashSet<>());
    }
}
