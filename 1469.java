import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        if (node == null) return new ArrayList<>(Arrays.asList(-1));
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            Node temp = que.poll();
            if (temp.left != null && temp.right != null) {
                que.add(temp.left);
                que.add(temp.right);
            } else if (temp.left != null) {
                que.add(temp.left);
                ans.add(temp.left.data);
            } else if (temp.right != null) {
                que.add(temp.right);
                ans.add(temp.right.data);
            }
        }
        return ans.isEmpty() ? new ArrayList<>(Arrays.asList(-1)) : ans;
    }
}