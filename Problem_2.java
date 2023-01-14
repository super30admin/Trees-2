// Time Complexity : O(n)
// Space Complexity : O(h) to keep the recursion stack, where h is the height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approch
// A number is formed, when it's a leaf node. So we have to traverse untill we get a node which both left & right children are null.
// initialize a local variable current sum &calculate it for every index. everytime we push a number to the recursive stack, will do current sum * 10 & then add the root value.
// when we hit a leaf node add the current sum to the global sum variable.


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
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum) {
        //base
        if(root == null)
            return;

        currNum = currNum*10 + root.val; //4, 4
        helper(root.left, currNum);
        //st.pop //root=9 //4*10 +9 = 49
        //root=5 //49*10+5 = 495

        if(root.left == null && root.right == null) { //here we hit the leaf node
            result += currNum;
        }
        helper(root.right, currNum);
    }
}