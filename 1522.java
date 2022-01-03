class Solution {
    public int helper(Node node, int[] dia) {
        if (node.children.size() == 0) return 0;
        int maxH1 = -1, maxH2 = -1;
        for (Node child: node.children) {
            int h = helper(child, dia);
            if (h > maxH1) {
                maxH2 = maxH1;
                maxH1 = h;
            } else if (h > maxH2) {
                maxH2 = h;
            }
            dia[0] = Math.max(dia[0], maxH1 + maxH2 + 2);
        }
        return maxH1 + 1;
    }
    public int diameter(Node root) {
        if (root == null || root.children.size() == 0) return 0;
        int[] dia = new int[1];
        helper(root, dia);
        return dia[0];
    }
}
