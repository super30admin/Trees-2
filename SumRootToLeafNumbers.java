/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity :O(n)
// Space Complexity :O(1)


class Solution {

	Integer result;

    public int sumNumbers(TreeNode root) {
        result = 0;
        if(root == null) {
        	return result;
        }

        helper(root, 0);
        return result;
    }

    private void helper(TreeNode node, int runningValue) {
    	if(node.left == null && node.right == null) {
    		result += runningValue * 10 + node.val;
    		return;
    	}

    	runningValue = runningValue * 10 + node.val;

    	if(node.left != null) {
    		helper(node.left, runningValue);
    	}

    	if(node.right != null) {
    		helper(node.right, runningValue);
    	}
    }
}