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

    public Node treeToDoublyList(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;

        helper(root);

        Node head = dummy.right;
        dummy.right = root.left = null;
        return head;
    }
}