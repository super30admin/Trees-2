// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int currSum) {
        // if there's an input - node with left tree null but right with some value
        if(root == null) return 0;
        // when leaf node is reached, we return the overall sum to the caller
        if(root.left == null && root.right == null) {
            return currSum * 10 + root.val;
        }
        // finally, we will keep adding left and right subTrees
        return helper(root.left, currSum*10+root.val) +
                helper(root.right, currSum*10+root.val);
    }
}