# /**
#  * Definition for a binary tree node.
#  * public class TreeNode {
#  *     int val;
#  *     TreeNode left;
#  *     TreeNode right;
#  *     TreeNode() {}
#  *     TreeNode(int val) { this.val = val; }
#  *     TreeNode(int val, TreeNode left, TreeNode right) {
#  *         this.val = val;
#  *         this.left = left;
#  *         this.right = right;
#  *     }
#  * }
#  */

# Problem129 - Sum root to leaf number
# TIme - O(n)
# Space - O(n)
class Solution {
    
    int result = 0;
    
    public int sumNumbers(TreeNode root) {
        int num = 0;
        helper(root, num);
        return result;
        
    }
    
    private void helper(TreeNode root, int num){
        
        if(root == null){
            
            return;
        }
        
        if(root.left == null && root.right == null){
            
            num = num * 10 + root.val;
            
            result = result + num;
            
        }
        
        num = num * 10 + root.val;
        helper(root.left, num);
        helper(root.right, num);
     
    }
    
}