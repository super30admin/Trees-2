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
        if(root==null) 
        {
            return sum;
        }
        totalSum(root, 0);			//Traversing the tree till it reaches the leaf and making the number according to description given
        return sum;					//once reaching the leaf, adding the number to total sum. This process will be repeated till we cover all the nodes.
    }								//	
    
    private void totalSum(TreeNode root, int currSum)	//adding all the numbers sum and returning the value.
    {
        if(root==null)
            return;
        currSum = currSum*10+root.val;
        if(root.left == null && root.right == null)
        {
            sum+=currSum;
        }
        
        totalSum(root.left, currSum);
        totalSum(root.right, currSum);
    }
}