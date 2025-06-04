//Problem: Sum root to leaf numbers

//Sum root to leaf numbers : void based recursion

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int curr){
        //base
        if(root == null) return;
        
        //logic
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null){ //checks if node is leaf node. This is done at preorder level.
            result += curr;
        } 
        helper(root.left, curr);
        helper(root.right, curr);
    }
}


//Sum root to leaf numbers: int based recursion

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
       return helper(root, 0);
    }
    public int helper(TreeNode root, int curr){
        //base
        if(root == null) return 0;
        
        //logic
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null){
            System.out.println(curr);
            return curr;
        } 
        int left = helper(root.left, curr);
        int right = helper(root.right, curr);
        //System.out.println(result);
        return left+right;
    }
}
