// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int sumNumbers(TreeNode root) {
        /* Recursive One way */
        if(root==null) return 0;
        
        return helper(root,0);
    }
    
    private int helper(TreeNode root, int currSum)
    {
        /* Base Case */
        if(root==null) return 0;
        
        if(root.left==null && root.right==null)
            return currSum*10+root.val;
        
        /* Logic - Recurse */
        int left = helper(root.left, currSum*10+root.val);
        int right = helper(root.right, currSum*10+root.val);
        
        /* Return */
        return left + right;
    }
}