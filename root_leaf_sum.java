//TimeComplexity O(n)
//SpaceComplexity O(h)

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    
    private void helper(TreeNode root, int prev){
        
        if(root == null)return;
        
        int curr = root.val;
        
        prev = prev*10 + curr;
       
        helper(root.left,prev);
        
        if(root.left == null && root.right == null){
          
            sum += prev;
        }
                 
        helper(root.right,prev);
    }
}
