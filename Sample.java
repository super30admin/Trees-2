// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        preOrderSum(root, 0);
        System.out.println(sum);
        return sum;
    }
    private void preOrderSum(TreeNode root, int num) {
        
        //base case:
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            sum += num*10 + root.val;
            return;
        }
        
        // logic
        preOrderSum(root.left, num*10 + root.val);
        
        preOrderSum(root.right, num*10 + root.val);
        
    }
}
