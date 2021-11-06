// 129 Sum Root to Leaf Numbers
// solved on leetcode
// Time complexity - O(n)
// Space complexity - O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int result=0;
    
    public int sumNumbers(TreeNode root) {
        int number=0;
        
        helper(root,number);
        return result;
        
    }
    
    public void  helper(TreeNode root,int num){
        if(root==null){
            return  ;
        }
        num= num*10+ root.val;
         helper(root.left,num);
        if(root.left==null && root.right==null){
            result+=num;
            return;
        }
        helper(root.right,num);
        
    }
    

}