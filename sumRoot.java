class Solution {
    
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int num = 0;
        helper(root, num);
        return sum;
    }
    
    public void helper(TreeNode root, int num){
        if(root == null)
            return;
        
        //action
        if(root.left == null && root.right == null)
            sum = sum + num * 10 + root.val;
        
        //recurse
        helper(root.left, num * 10 + root.val);
        helper(root.right, num * 10 + root.val);
    }
}