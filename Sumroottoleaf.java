// Time Complexity :O(N) where n is the number of nodes 
// Space Complexity :O(H) where H is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
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
    int result=0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        sum(root,0);
        return result;
    }
    public void sum(TreeNode root, int currSum){
        if(root == null)
            return;
        if(root.left==null && root.right ==null){
            result+=currSum*10 +root.val;
            return;
        }
            sum(root.left,currSum*10+root.val);
            sum(root.right,currSum*10+root.val);
    }
}