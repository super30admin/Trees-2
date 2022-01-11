/*
Time Complexity : O(N) where N is the number of nodes
Space Complexity : O(H) which is the height of recursion stack at any moment
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no


Your code here along with comments explaining your approach

I used recursive method to form this solution, whenever a leaf node is encountered
we use that value to add to our global sum. Otherwise we keep iterating left
and right from each node

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

    int sum;

    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }

    public void helper(TreeNode root, int prev){
        if(root != null){
            if(root.left == null && root.right == null)
            {
                // if it is a leaf node
                sum += prev*10 + root.val;
                return;
            }
        }
        else{
            return;
        }

        helper(root.left, prev*10+root.val);
        helper(root.right, prev*10+root.val);
        return;

    }
}
