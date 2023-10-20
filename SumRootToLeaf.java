
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//Approach: Start from root and travel recursively by visiting left trees of root nad then right trees of root once reaches
//leaf add the current sum to result and return result.
public class SumRootToLeaf {
    int result;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum) {
        if (root == null) return;

        currNum = currNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += currNum;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
