/**
 * 
 * Leet Code -  129
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
        if (root == null) return 0;
        int currentSum = root.val;
        return computeSum(root,currentSum);
    }
    private int computeSum(TreeNode root,int currentSum)
    {
        //base 
        if(root.left == null && root.right == null)
            return currentSum;
        if(root.left == null && root.right != null)
            return computeSum(root.right,(currentSum*10)+root.right.val);
        if(root.left != null && root.right == null)
            return computeSum(root.left,(currentSum*10)+root.left.val);
            
        //logic
        //st.push(root, currentSum)
        int valLeft = computeSum(root.left,(currentSum*10)+root.left.val);
        //st.pop() -- root and currentSum
        //st.push(root, currentSum)
        int valRight = computeSum(root.right,(currentSum*10)+root.right.val);
        //st.pop() -- root and currentSum
        
        //Split to understand push and pop better!
        return valLeft+valRight;
    }
}