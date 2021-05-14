// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class sumLeafNode {
    int result;
    public int sumNumbers(TreeNode root) {
        int currSum=0; 
        
        helper(root,0);
        return result;
        
    }
    
    private void helper(TreeNode root, int currSum){
        
        if(root==null)
            return;
        
        currSum=currSum*10+root.val;
        helper(root.left, currSum);
        
        if(root.left==null && root.right==null){
            result+=currSum;
                      
        }
        helper(root.right, currSum);       
        
        
    }
    
}
