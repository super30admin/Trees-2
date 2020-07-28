// Time Complexity : O(N)
// Space Complexity : O(H) height of tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

basically I am performing the preOrder Traversal and updating the sum.


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
    
    public void helper(TreeNode r, int currNumber)
    {
        if(r != null)
        {
            currNumber = currNumber * 10 + r.val;
            if(r.left == null && r.right == null)
            {
                sum += currNumber;
            }
            helper(r.left,currNumber);
            helper(r.right, currNumber);
        }
    }
    public int sumNumbers(TreeNode root) {
    helper(root,0);
        return sum;
    }
}