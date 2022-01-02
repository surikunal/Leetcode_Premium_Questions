import java.util.List;
import java.util.ArrayList;
public class Solution {
    private int helper(List<List<Integer>> ans, TreeNode root) {
        if (root == null) return -1;
        int left = helper(ans, root.left);
        int right = helper(ans, root.right);
        int curr = Math.max(left, right) + 1;
        if (ans.size() <= curr) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(curr).add(root.val);
        return curr;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    } 
}


For this question we need to take bottom-up approach. The key is to find the height of each node. Here the definition of height is:
The height of a node is the number of edges from the node to the deepest leaf. --CMU 15-121 Binary Trees

I used a helper function to return the height of current node. According to the definition, the height of leaf is 0. h(node) = 1 + max(h(node.left), h(node.right)).
The height of a node is also the its index in the result list (res). For example, leaves, whose heights are 0, are stored in res[0]. Once we find the height of a node, we can put it directly into the result.
