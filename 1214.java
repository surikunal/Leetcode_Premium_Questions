// resursive approch with using space =============================================

class Solution {
    public HashSet<Integer> inorder(TreeNode node, HashSet<Integer> map) {
        if (node == null) return map;
        inorder(node.left, map);
        map.add(node.val);
        inorder(node.right, map);
        return map;
    }
    public boolean find(TreeNode node, int target, HashSet<Integer> map) {
        if (node == null) return false;
        boolean res = false;
        res = res || find(node.left, target, map);
        if (map.contains(target - node.val)) return true;
        res = res || find(node.right, target, map);
        return res;
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> map = inorder(root1, new HashSet<>());
        return find(root2, target, map);
    }
}

// Resursive approch without using space =============================================
// but giving TLE
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        int sum = root1.val + root2.val;
        if (sum == target) return true;
        else if (sum > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        else return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    }
}
