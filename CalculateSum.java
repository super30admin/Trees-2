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
 // This solution does a recursice approach to calculate number from root to leaf and at the end adding the summed value to the global value. At the end of the tree traversal we will have sum of all the leaf values calculated with running number
class Solution {
    int finalSum = 0;
    public int sumNumbers(TreeNode root) {
        sumItUp(root, 0);
        return finalSum;
    }

    private void sumItUp(TreeNode root, int runningNumber) {
       if(root==null) return;
        int sum = runningNumber*10+root.val;
        if(root.left==null && root.right==null) {
            finalSum+=sum;
            return;
        }
        sumItUp(root.left, sum);
        sumItUp(root.right, sum);
    }
}
