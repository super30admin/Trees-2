/*
  Time complexity: O(n)
  Space complexity: O(h)

  Code ran successfully on Leetcode: Yes

  Approach: The sum of the numbers formed by traversal from root to leaf are summed up to find the result. The leaf is recognized as the node for which left and right subtrees are null.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int result;
    public int SumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int current)
    {
        if(root==null) return;
        current = current*10+root.val;
        
        if(root.left==null && root.right==null)
            result+=current;

        helper(root.left,current);
        helper(root.right,current);
    }
}
