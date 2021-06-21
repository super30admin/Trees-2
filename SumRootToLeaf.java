//TC O(N)
//SC O(H) where H is the height of tree

class Solution {
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root,0);
        
    }
    
    private int helper(TreeNode root, int currSum){
        //base case        
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return currSum*10 + root.val;
    
        //logic
        currSum = currSum*10 + root.val;
        int case1 = helper(root.left, currSum);
        
        //stack.pop and currSum are coming from stack
        int case2 = helper(root.right, currSum);
        
        //when left& right subtree hits leaf it returns result add them and return
        return case1 + case2;     
    }
}