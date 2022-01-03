// Recursive ===========================================================
class Solution {
    public void preorder(Node node, int[] f, int val) {
        if (node == null) return;
        if (node.val >= 'a' && node.val <= 'z') f[node.val - 'a'] += val;
        preorder(node.left, f, val);
        preorder(node.right, f, val);
    }
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] f = new int[26];
        preorder(root1, f, 1);
        preorder(root2, f, -1);
        for (int i: f)
            if (i != 0) return false;
        return true;
    }
}
// Iterative ===========================================================
// Moris
class Solution {
    public void preorder(Node node, int[] f, int val) {
        Node curr = node;
        while (curr != null) {
            if (curr.left != null) {
                Node currp1 = curr.left;
                while (currp1.right != null && currp1.right != curr) currp1 = currp1.right;
                if (currp1.right == null) {
                    if (curr.val >= 'a' && curr.val <= 'z')
                        f[curr.val - 'a'] += val;
                    currp1.right = curr;
                    curr = curr.left;
                } else if (currp1.right == curr) {
                    currp1.right = null;
                    curr = curr.right;
                }
            } else {
                if (curr.val >= 'a' && curr.val <= 'z')
                    f[curr.val - 'a'] += val;
                curr = curr.right;
            }
        }
    }
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] f = new int[26];
        preorder(root1, f, 1);
        preorder(root2, f, -1);
        for (int i: f)
            if (i != 0) return false;
        return true;
    }
}
