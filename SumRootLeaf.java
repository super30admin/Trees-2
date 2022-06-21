// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class SumRootLeaf {
    //int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return root.val;
        
        if(root.left!=null)
            root.left.val = root.val*10+root.left.val;
        
        if(root.right!=null)
            root.right.val = root.val*10+root.right.val;
        
        return sumNumbers(root.left)+sumNumbers(root.right);
    }
}
