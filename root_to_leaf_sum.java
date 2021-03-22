class Solution {
    int output = 0; //Global variable to keep track of output sum
    // we are taking this global variable because we want to update output only for leaf node
    public int sumNumbers(TreeNode root) {
        int currSum=0;//initial sum is 0
        
        rootToLeaf(root,currSum);//calling recursion function
        
        return output;
    }
    
    private void rootToLeaf(TreeNode root,int currSum){
        if(root==null){
            return ;
        }
        
        
        currSum=currSum*10+root.val;//formula for calculating sum as required
        
        
        //add to output only if it is a leaf node
        if(root.left==null && root.right==null){
            output+=currSum;
            return ;
        }
        
        //for both recursion calls, pass the parent currSum
        rootToLeaf(root.right,currSum);
        rootToLeaf(root.left, currSum);
    }
}
