// Time Complexity :  O(n) n number of nodes in the tree
// Space Complexity : O(h) height of the tree, in worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// You can use solve using both iterative and recursive solution for this. I have used recursion to solve it.
// It will be depth first search to go through each path from root to leaf and  keep a variable for current sum.
// Anytime we see a leaf node, we add the current sum to the total sum(result variable).

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
    Integer result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(0, root);
        return result;
    }

    private void dfs(Integer currSum, TreeNode node) {
        List<TreeNode> children = getChildren(node);
        if (children.isEmpty()) {
            result += (currSum * 10 + node.val);
            return;
        }
        for (TreeNode child : children) {
            dfs(currSum * 10 + node.val, child);
        }
    }


    private List<TreeNode> getChildren(TreeNode root) {
        ArrayList<TreeNode> children = new ArrayList<>();
        if (root.left != null) {
            children.add(root.left);
        }

        if (root.right != null) {
            children.add(root.right);
        }
        return children;
    }
}
