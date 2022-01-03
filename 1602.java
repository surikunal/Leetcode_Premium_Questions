// Double queue method ===================================================

class Solution {
    public TreeNode findNearestRightNode(TreeNode node, TreeNode u) {
        if (node == null || node == u) return null;
        Queue<TreeNode> par = new LinkedList<>();
        Queue<TreeNode> child = new LinkedList<>();
        par.add(node);
        while (!par.isEmpty()) {
            int size = par.size();
            while (size-- > 0) {
                TreeNode rem = par.poll();
                if (rem == u) return par.poll();
                if (rem.left != null) child.add(rem.left);
                if (rem.right != null) child.add(rem.right);
            }
            Queue<TreeNode> t = par;
            par = child;
            child = t;
        }
        return null;
    }
}

// null queue method ===================================================

class Solution {
    public TreeNode findNearestRightNode(TreeNode node, TreeNode u) {
        if (node == null || node == u) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(node);
        que.add(null);
        while (!que.isEmpty()) {
            TreeNode rem = que.poll();
            if (rem == null) {
                que.add(null);
            } else {
                if (rem == u) return que.poll();
                if (rem.left != null) que.add(rem.left);
                if (rem.right != null) que.add(rem.right);
            }
        }
        return null;
    }
}


// Level size measurement method ===================================================
class Solution {
    public TreeNode findNearestRightNode(TreeNode node, TreeNode u) {
        if (node == null || node == u) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(node);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode rem = que.poll();
                if (rem == u) {
                    if (size == 0) return null;
                    else return que.poll();
                }
                if (rem.left != null) que.add(rem.left);
                if (rem.right != null) que.add(rem.right);
            }
        }
        return null;
    }
}
