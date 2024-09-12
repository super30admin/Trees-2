// Time Complexity : O(n) --> where n is length of input array
// Space Complexity : O(h) --> where h is height of tree (log n to n)
// Did this code successfully run on Leetcode (129): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int currSum) {
        // base case
        if (root == null) return 0;
        
        // logic (check for leaf)
        if (root.left == null && root.right == null) return currSum * 10 + root.val;
        
        return helper(root.left, currSum * 10 + root.val) + helper(root.right, currSum * 10 + root.val);
    }
}