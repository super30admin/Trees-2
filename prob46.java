//tc: O(n)
//sc:O(height of tree)

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
    
    int rootToLeaf =0;
    
    public void preorder(TreeNode r, int currNumber){
        if(r!= null){
            
            currNumber = currNumber *10+ r.val;
            if(r.left == null && r.right == null){
                rootToLeaf += currNumber;
            }
            
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }
    
    public int sumNumbers(TreeNode root){
        preorder(root,0);
        return rootToLeaf;
    }
}