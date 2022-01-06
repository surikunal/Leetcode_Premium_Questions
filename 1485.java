
// Recursive using HashMap =======================================================


class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        dfsCopy(root, map);
        dfsConnect(root, map);
        return map.get(root);
    }
    
    public NodeCopy dfsCopy(Node node, Map<Node, NodeCopy> map) {
        if (node == null) return null;
        NodeCopy ans = new NodeCopy(node.val);
        map.put(node, ans);
        dfsCopy(node.left, map);
        dfsCopy(node.right, map);
        return ans;
    }
    
    public void dfsConnect(Node node, Map<Node, NodeCopy> map) {
        if (node == null) return;
        if (node.left != null) map.get(node).left = map.get(node.left);
        if (node.right != null) map.get(node).right = map.get(node.right);
        if (node.random != null) map.get(node).random = map.get(node.random);
        dfsConnect(node.left, map);
        dfsConnect(node.right, map);
    }
}

// Iterative using HashMap =======================================================

class Solution {
    public NodeCopy copyRandomBinaryTree(Node node) {
        if (node == null) return null;
        
        Map<Node, NodeCopy> map = new HashMap<>();
        Stack<Node> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node rem = st.pop();
            NodeCopy ans = new NodeCopy(rem.val);
            map.put(rem, ans);
            if (rem.left != null) st.push(rem.left);
            if (rem.right != null) st.push(rem.right);
        }
        
        st.push(node);
        while (!st.isEmpty()) {
            Node rem = st.pop();
            if (rem.left != null) {
                map.get(rem).left = map.get(rem.left);
                st.push(rem.left);
            }
            if (rem.right != null) {
                map.get(rem).right = map.get(rem.right);
                st.push(rem.right);
            }
            if (rem.random != null) {
                map.get(rem).random = map.get(rem.random);
            }
        }
        return map.get(node);
    }
}

// BFS =======================================================

class Solution {
    public NodeCopy copyRandomBinaryTree(Node node) {
        if (node == null) return null;
        Map<Node, NodeCopy> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        map.put(node, new NodeCopy(node.val));
        while (!que.isEmpty()) {
            Node temp = que.poll();
            if (temp.left != null) {
                if (!map.containsKey(temp.left)) map.put(temp.left, new NodeCopy(temp.left.val));
                map.get(temp).left = map.get(temp.left);
                que.add(temp.left);
            }
            if (temp.right != null) {
                if (!map.containsKey(temp.right)) map.put(temp.right, new NodeCopy(temp.right.val));
                map.get(temp).right = map.get(temp.right);
                que.add(temp.right);
            }
            if (temp.random != null) {
                if (!map.containsKey(temp.random)) map.put(temp.random, new NodeCopy(temp.random.val));
                map.get(temp).random = map.get(temp.random);
            }
        }
        return map.get(node);
    }
}

// DFS =======================================================

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        return dfs(root, map);
    }
    
    public NodeCopy dfs(Node node, Map<Node, NodeCopy> map) {
        if (node == null) return null;
        
        if (map.containsKey(node)) return map.get(node);
        
        NodeCopy newNode = new NodeCopy(node.val);
        map.put(node, newNode);
        
        newNode.left = dfs(node.left, map);
        newNode.right = dfs(node.right, map);
        newNode.random = dfs(node.random, map);
        return newNode;
    }
}
