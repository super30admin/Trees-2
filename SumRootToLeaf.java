// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// curValue holds the digits of the path traversed from the root to the node. If the node is a leaf we return the all the path values to the parent, if the node is null, we return 0. The parent recieves sums from left and right and returns the sum to its parent. The root finally returns the total sum at every leaf node alone.

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode root, int currValue){
        if(root == null) return 0;

        currValue = currValue*10 + root.val;
        if(root.left == null && root.right == null) return currValue;

        int left = helper(root.left,currValue);        
        int right = helper(root.right,currValue);
        
        return  left + right;
    }
}