Approach 1
Intuition: Memorize the path of any of the given nodes to the route, and then find the intersection point while traversing from the other node to root.
Time complexity: O(h) - h is height of deeper node
Space complexity: O(h) - h is height of deeper node

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> map = new HashSet<>();
        while (p != null) {
            map.add(p.val);
            p = p.parent;
        }
        while (q != null) {
            if (map.contains(q.val)) return q;
            q = q.parent;
        }
        return null;
    }
}

Approach 2
Intuition: I think this approach is discussed in "Green Book" - find out the height of both the nodes, and traverse upwards from the deeper node to make sure we start our search at same level for both the nodes. Then the search step is pretty simple - traverse upwards till we meet.
Time complexity: O(h): h = height of deeper node
Space complexity: O(1)
 
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int depth1 = depth(p);
        int depth2 = depth(q);
        if (depth1 < depth2) {
            Node t = p;
            p = q;
            q = t;
            
            int temp = depth1;
            depth1 = depth2;
            depth2 = temp;
        }
        while (depth1-- > depth2)
            p = p.parent;
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
    public int depth(Node node) {
        int ans = 0;
        while (node != null) {
            node = node.parent;
            ans++;
        }
        return ans;
    }
}
