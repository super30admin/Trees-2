/*
Runtime complexity - O(N) where N is the number of elements in the tree
Space complexity - O(H) where H is the height of the tree for the stack space.
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
class Solution {
    public int total=0;
    public int sumNumbers(TreeNode root) {
        int sum=0;
        traversal(root,sum);
        return total;
    }
    void traversal(TreeNode root,int sum)
    {
        if(root==null)
            return;
        sum=sum*10+root.val;
        traversal(root.left,sum);
        if(root.left==null && root.right==null)
            total=total+sum;
        traversal(root.right,sum);

    }
}
