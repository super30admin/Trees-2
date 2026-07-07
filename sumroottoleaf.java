// Time Complexity : O(n)
// Space Complexity : O(n) - for the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes while calculating the current number, I was not multiplying the previous number by 10 before adding the current node value, which was giving me wrong results. After fixing that, it worked fine.


// Your code here along with comments explaining your approach: using helper function to traverse the tree in a depth-first manner, keeping track of the current number formed by the path from root to leaf. When a leaf node is reached, add the current number to the result. The current number is calculated by multiplying the previous number by 10 and adding the current node's value.
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
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum){
        // base case
        if(root == null) return;

        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null){
            result += currNum;
        }

        helper(root.left, currNum);

        helper(root.right, currNum);
    }
}
