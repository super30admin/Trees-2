// Time Complexity : O (N)
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/sum-root-to-leaf-numbers/

/**
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
class Problem2 {

    int rootToLeaf = 0;

    public void preorder(TreeNode root, int currNumber) {

        if (root != null)
        {
            currNumber = currNumber * 10 + root.val;
            if (root.left == null && root.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(root.left, currNumber);
            preorder(root.right, currNumber) ;
        }
    }

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
}