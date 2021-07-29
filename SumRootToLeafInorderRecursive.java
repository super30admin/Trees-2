// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    
    //Solving inoder traverse the recursive way
    int result ;
    public int sumNumbers(TreeNode root) {
        
        if(root == null)
            return 0;
        
        helper(root, 0);
        return result;
        
    }
    
    private void helper(TreeNode root, int currSum){
        //base
        if(root == null) return;
        
        //left
        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);
        if(root.left == null && root.right == null)
            result += currSum;
        
        //right
        helper(root.right, currSum);
    }
}