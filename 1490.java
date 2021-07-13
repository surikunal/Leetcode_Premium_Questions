/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        Node ans = null;
        if (root != null) {
            ans = new Node(root.val);
            for (Node child: children) {
                ans.children.add(cloneTree(child));
            }
        }
        return ans;
    }
}