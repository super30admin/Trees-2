//Time Complexity : O(n)
//Space Complexity : O(h) h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root, int curSum){
        if(root == null)
            return;
        helper(root.left, curSum * 10 + root.val);
        if(root.left == null && root.right == null)
            sum = sum + curSum * 10 + root.val;
        helper(root.right, curSum * 10 + root.val);
    }
}
