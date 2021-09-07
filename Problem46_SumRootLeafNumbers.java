// Time Complexity : O(n)
// Space Complexity : O(h), h -> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    public int sum(TreeNode root, int curSum) {
        if(root == null)
            return 0;
        curSum = curSum * 10 + root.val;
        if(root.left == null && root.right == null)
            return curSum;
        int leftSum = sum(root.left, curSum);
        int rightSum = sum(root.right, curSum);
        return leftSum + rightSum;
    }
}