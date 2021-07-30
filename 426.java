class Solution {
    public static Node prev;

    public void helper(Node node) {
        if (node == null)
            return;
        helper(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        helper(node.right);
    }

    // ================================RECURSIVE=================================
    // tree to doubly linked list
    public Node treeToDoublyList(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;

        helper(root);

        Node head = dummy.right;
        dummy.right = root.left = null;
        return head;
    }

    // tree to cyclic doubly linked list
    Node bTreeToClist(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;

        helper(root);

        Node head = dummy.right;
        dummy.right = head.left = null;

        head.left = prev;
        prev.right = head;

        return head;
    }
    // ================================ITERARIVE=================================
    // tree to doubly linked list

    void insertAllLeft(LinkedList<Node> st, Node node) {
        while (node != null) {
            st.addFirst(node);
            node = node.left;
        }
    }

    Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        Node prev = dummy;

        LinkedList<Node> st = new LinkedList<>();
        insertAllLeft(st, root);

        while (st.size() != 0) {
            Node curr = st.removeFirst();
            prev.right = curr;
            curr.left = prev;
            prev = curr;

            insertAllLeft(st, curr.right);
        }
        Node head = dummy.right;

        dummy.right = head.left = null;
        return head;
    }

    // tree to cyclic doubly linked list
    void insertAllLeft(LinkedList<Node> st, Node node) {
        while (node != null) {
            st.addFirst(node);
            node = node.left;
        }
    }

    Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        Node prev = dummy;

        LinkedList<Node> st = new LinkedList<>();
        insertAllLeft(st, root);

        while (st.size() != 0) {
            Node curr = st.removeFirst();
            prev.right = curr;
            curr.left = prev;
            prev = curr;

            insertAllLeft(st, curr.right);
        }
        Node head = dummy.right;
        dummy.right = head.left = null;

        prev.right = head;
        head.left = prev;

        return head;
    }

}