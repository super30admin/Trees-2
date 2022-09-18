class Solution {

    public class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public int sumNumbers(TreeNode root) {
        
        
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int sum){
        if(root==null){return 0;}
        
        if(root.left==null && root.right==null){
            return sum*10+root.val; //495..491
        }
        
        
        
        
            int y=    helper(root.right,sum*10+root.val);     
           int x=   helper(root.left,sum*10+root.val);
        
          
          
           return x+y; 
                   
    }
    
}
//TC: O(n);
//SC: recursive stack 