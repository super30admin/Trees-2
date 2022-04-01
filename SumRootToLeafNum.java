// Time Complexity : O(n) n nodes in the tree
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

    //global variable for recursion
    public int sum;

    public int sumNumbers(TreeNode root) {

        if (root == null)
            return 0;

        inorder(root, 0);

        return sum;
    }

    private void inorder(TreeNode root, int num)
    {
        if(root == null)
            return;

        //form the number at each node
        //num is local to recursion
        num = num * 10 + root.val;

        inorder(root.left, num);
        //st.pop()

        //processing of root that pops out
        //we check if we have reached the leaf node, add current num to sum
        if(root.left == null && root.right == null)
            sum += num;

        inorder(root.right, num);
        //st.pop()
    }
}
