// Time Complexity: O(n)
// Space Complexity: O(h)
// Did this code successfully run on Leetcode : Yes

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        //base
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        //logic
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}
