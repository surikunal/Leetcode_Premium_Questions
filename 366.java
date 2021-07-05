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
