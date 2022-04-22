// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h) and h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    public int sumNumbers(TreeNode root) {
        if(root ==null)
            return 0;
        return helper(root,0);
    }
    private int helper(TreeNode root, int currSum){
        if(root ==null) return 0;
        if(root.left==null&&root.right==null){
            return currSum*10+root.val;
        }
        int case1 = helper(root.left,currSum*10+root.val);
        int case2 = helper(root.right,currSum*10+root.val);
        return case1+case2;
    }
}

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root ==null)
            return 0;
        helper(root,0);
	return sum;
    }
    private void helper(TreeNode root, int currSum){
        if(root ==null) return;
        if(root.left==null&&root.right==null){
            sum = sum + currSum*10+root.val;
        }
        helper(root.left,currSum*10+root.val);
        helper(root.right,currSum*10+root.val);
    }
}