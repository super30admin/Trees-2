// Time Complexity :O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use a class variable to keep track of final result
 * Now we iterate over tree and whenever we hit child node, we calculate current number and add it to final result
 * and we use base condition as, whenever we hit null we return
 * This will add all numbers we are forming in each path to child node
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
    int ans;
    public int sumNumbers(TreeNode root) {
      check(root, 0);
      return ans;
    }
    
    private void check(TreeNode root, int curr){
        if(root == null)return;
        if(root.left == null && root.right == null){
            ans = ans + (curr * 10 + root.val);
            return;
        }
        check(root.left, curr * 10 + root.val);
        check(root.right, curr * 10 + root.val);
    }
}