/* TC: O(n) n: no. of nodes in the tree
 * SC: O(h) h:height of the tree for call stack.
 * Approach: Recursive all to my left as well as right sub-tress and at each call i will 
 * add the root.val to my string and at each left node i will convert my string into (int)result. 
 */


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

        int sum = 0;
    public int sumNumbers(TreeNode root) {
        String str = "";
         helper(root, str);
         return sum;
    }

    private void helper(TreeNode root, String str){
        //base 
        if(root == null) return;

        str += String.valueOf(root.val);

        if(root.left == null && root.right == null){
            int pathRes = Integer.parseInt(str);
            sum += pathRes;
        } 
        helper(root.left, str);
        helper(root.right, str);
    }
}