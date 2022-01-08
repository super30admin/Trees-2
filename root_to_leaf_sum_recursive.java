// Time Complexity : O(n)
// Space Complexity : O(n) - Recursive Stack  O(n)- Iterative (Stack)


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
    int result = 0; //Must be global as the prev value of res must be stored for every recursive call.
    public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }
    
    
    public int preorder(TreeNode root, int num){
        
        // Using Preorder Traversal : Recursion
        if (root == null){
            return 0;
        }
        
        // Base Case :
        if  (root.left == null && root.right == null){
            result += (num * 10) + root.val;
            return result;
        }
        // N L R
        // node
        num = num * 10 + root.val;
        
        // left sub tree
        preorder(root.left,num);
        
        // right sub tree
        preorder(root.right, num);
        
        return result;
    }
    

}