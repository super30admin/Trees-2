/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *   Space Complexity - Without Recursive Stack - O(n)
 *                      With Recursive Stack - O(log(n))
 */

class Solution {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }

    private void helper(TreeNode curr, int currSum){

        if(curr == null)
            return;

        if(curr.left == null && curr.right == null){
            sum += ((currSum*10) + curr.val);
            return;
        }
        int val = currSum*10 + curr.val;
        helper(curr.left, val);
        helper(curr.right,val);
    }
}