// 129. Sum Root to Leaf Numbers

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
    
    int result;
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int currSum){
        // base condition 
        if(root == null) return;
        
  //      if(root.left == null && root.right == null){
  //          result = result + currSum*10 + root.val;
  //      }            
        // Logic
        currSum = currSum*10 + root.val;
        
        helper(root.left, currSum);
        
        if(root.left == null && root.right == null){
            result = result + currSum;
        } // to save one more recursion we will do this after base condition ... as a preorder // traversal
        
        helper(root.right, currSum);
        
    }
}

/* 
Complexity Analysis

Time complexity: O(N) since one has to visit each node.

Space complexity: up to O(H) to keep the recursion stack, where H is a tree height.
*/
