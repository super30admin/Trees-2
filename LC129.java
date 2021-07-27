class Solution {
    public int sumNumbers(TreeNode root) {
        recurr(root, 0);
        return output;
    }
    
    int output = 0;
    
    private void recurr(TreeNode root, int prev){
        if(root == null){
            return;
        }
        
        int curr = prev*10 + root.val;
        
        if(root.left == null && root.right == null){
            output += curr;
        }
        
        recurr(root.left, curr);
        recurr(root.right, curr);
    }
}

//Time : O(n)
//Space : O(n)