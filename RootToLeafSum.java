// Time Complexity : O(n) n is number of nodes 
// Space Complexity :O(1) for recursive solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class RootToLeafSum {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return helper(0,root);
    }
    
    private int helper(int sum,TreeNode root)
    {
        if(root==null) return 0;
        
        sum = sum*10+root.val;
        if(root.left==null && root.right==null)
        {
            result+=sum;
        }
        
        if(root.left!=null) helper(sum,root.left);
        if(root.right!=null) helper(sum,root.right);
        return result;
    }
}