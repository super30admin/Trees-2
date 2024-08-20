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

 // Time complexity = O(n)
 // Space complexity = O(1)
// Recursion with void result.
 // the result cannot be in the recursive stack, since if it is put in the recursive stack, 
 // we will get 0, no matter what we do.
class SumRootToLeafVoidRecursive {
    int res=0;
    public int sumNumbers(TreeNode root) {
        // root calculation needs to be done first.
        helper(root, 0);// start from the root val.
        return res;
    }
    
    private void helper(TreeNode root, int sum ) {
        if(root==null) {
            return;
        }
        sum = sum*10 + root.val; 
        if(root.left == null && root.right == null) {
            res += sum;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}