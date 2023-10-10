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
    int sum = 0;
    public int sumNumbers(TreeNode root) {

        if(root == null)
        {
            return 0;
        }
        inorder(root, 0);
        return sum;  
    }

    private void inorder(TreeNode root, int currSum)
    {
        if(root ==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            sum = sum + currSum*10+root.val;
        }
        inorder(root.left, currSum*10+root.val);
        inorder(root.right, currSum*10+root.val);    
    }
}

