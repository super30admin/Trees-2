class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        
        //TreeSum(root,0);
        
        return sumTree(root,0); // sum;
        
    }
    
    public void TreeSum(TreeNode root,int num){
        
        if(root==null) return;
        
        if(root.left==null && root.right==null)
            sum+=num*10+root.val;
        
        TreeSum(root.left,num*10+root.val);
        TreeSum(root.right,num*10+root.val);
        
        
    }
    
    public int sumTree(TreeNode root,int num)
    {
        if(root==null) return 0;
        
        if(root.left==null && root.right==null)
            return num*10+root.val;
        
        return sumTree(root.left,num*10+root.val)+sumTree(root.right,num*10+root.val);
    }
}


// Time Complexity : O(N)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no