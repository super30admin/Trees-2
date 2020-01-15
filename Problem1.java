// Time Complexity :
//      h - height of the BST, n is the number of elements
//      sumNumbers() - O(n)
//      
// Space Complexity :
//      sumNumbers() - O(h) stored as recursive stack space
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int global_sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return global_sum;
        
        helper(root, 0);
        
        return global_sum;
    }
    
    private void helper(TreeNode root, int localsum)
    {
        //Base Case
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            global_sum += localsum*10 + root.val;
            return;
        }
        
        //Logic
        helper(root.left, localsum * 10 + root.val);
        helper(root.right, localsum * 10 + root.val);
    }
}