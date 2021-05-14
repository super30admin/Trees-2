// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    InOrder to Find the Sum of all the paths, we use (val*10 + root.val)
    Since it is a recursive call, the value remains the same for both the left and right subtree for that particular element.
*/

class Solution {
    public int sumNumbers(TreeNode root) {
       return sumNode(root, 0); 
    }
    
    public int sumNode(TreeNode root, int val) {
        
        val = val*10 + root.val;
        
        if (root.left == null && root.right == null)
            return val;
        
        int l = 0;
        int r = 0;
        
        if (root.left != null)
            l = sumNode(root.left, val);
        if (root.right != null)
            r = sumNode(root.right, val);
            
        return l+r;
    }
}