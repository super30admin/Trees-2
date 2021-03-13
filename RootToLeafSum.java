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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return recurr(root.left, root.right);
    }
    
    private boolean recurr(TreeNode N1, TreeNode N2){
        if(N1==null && N2 == null){
            return true;
        }
        if(N1 == null || N2 == null || N1.val != N2.val){
            return false;
        }
        return recurr(N1.left, N2.right) && recurr(N1.right, N2.left);
    }
}

//TC: O(N)
//SC: O(1) if recursion stack is counted it would be O(height of the tree)
