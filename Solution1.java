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
 //TC : O(n) ..because we traverse all the nodes while finding path
 //SC : O(h)-> height of recursion stack
class Solution1 {
    int result;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return result;  
    }
    private void dfs(TreeNode root,int currSum)
    {    
        //base case is always a breaking condition to come out of function
        if(root==null)
        {
            return;
        }
        //action or logic
        currSum=currSum*10+root.val;
        if(root.left==null && root.right==null) //when we reach to left node
        {
            result+=currSum;
        }
        //recurse
        //go left
        dfs(root.left,currSum);
        //go right
        dfs(root.right,currSum);   
        //no backtrack
    }
}