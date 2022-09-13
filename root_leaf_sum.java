//TimeComplexity O(n)
//SpaceComplexity O(h)

class Solution {
    int sum;
    
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root, int curr){
       
        if(root == null)return; 
        
        curr = curr *10 + root.val;
        
        if(root.left == null && root.right == null){
            sum += curr;
        }
        
        
        helper(root.left,curr);
        helper(root.right,curr);
    }
}
