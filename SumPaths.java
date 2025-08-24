//Time Complexity: O(N) where N is number of nodes
//Space Complexity: O(H) where H is height of the tree(recursion stack space)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * The currSum is maintained in local scope since we need to revert to the previous state when we backtrack to the parent node.
 * When we reach a leaf node, we add the currSum to the result since it represents a complete root-to-leaf path.
 * We will update the currSum by multiplying the existing currSum by 10 and adding the current node's value to it. Finally we will return the result as it will have the sum of all root-to-leaf paths.
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
class SumPaths {
    int result=0;
    public int sumNumbers(TreeNode root) {
        int currSum=0;
        helper(root,currSum);
        return result;
    }
    public void helper(TreeNode root, int currSum)
    {

        if(root==null) return;
        currSum=currSum*10+root.val;
        if(root.left==null &root.right==null){result=result+currSum;}
        helper(root.left,currSum);
        helper(root.right,currSum);

        return;

    }
}