// Time Complexity : O(n) --> no.of nodes in tree
// Space Complexity : O(h) -- stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        this.sum =0;
        helper( root, 0);
        return sum;
        
    }
    public void helper(TreeNode root, int currSum)
    {
        if(root == null) return ;

       
        currSum = currSum *10 + root.val;
        if(root.left == null && root.right == null)
        sum  += currSum ;

        
        helper(root.left, currSum);
        helper (root.right, currSum);
    }
}