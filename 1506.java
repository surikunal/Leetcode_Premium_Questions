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
    public Node findRoot(List<Node> tree) {
        Integer value = 0;
        for (Node t: tree) {
            value = (value ^ t.val);
            for (Node child: t.children)
                value = (value ^ child.val);
        }
        for (Node node: tree) {
            if (value == node.val) {
                return node;
            }
        }
        return null;
    }
}

// problem discription is so confusing but solution pretty easy
