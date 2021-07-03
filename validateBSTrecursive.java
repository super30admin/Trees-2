//Recursive solution
//time complexity O(n)
//space complexity O(1)

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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
    }

    public boolean validBST(TreeNode root, Integer min, Integer max){
        //edge
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;


        //logic
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }
}
