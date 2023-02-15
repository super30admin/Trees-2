
//recursive
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int curr){
       
        //base
         if(root == null) return ;
        
        //chec if leaf node
        if(root.left == null && root.right == null){
            result += curr*10 + root.val;
        }      
        //logic
       helper(root.left, curr*10 + root.val);
       helper(root.right, curr*10 + root.val);
    }
}

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int curr){
       
        //base
         if(root == null) return 0 ;
        curr = curr*10 + root.val;
        //chec if leaf node
        if(root.left == null && root.right == null){
            return curr;
        }      
        //logic
       int left = helper(root.left, curr);
       int right = helper(root.right, curr);
        
        return left+right;
    }
   
}
