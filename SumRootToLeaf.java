/**
*  Time complexity : O(n)  n is number of nodes
Space complexity : O(h)  height of the tree
Submission successful on leetcode
*
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
      int sum;
    public int sumNumbers(TreeNode root) {
      
        if(root ==null) return 0;
        
        dfs(root,0);
        return sum;
        
    }
    private void dfs(TreeNode root, int num){
        //base
            if(root==null) return ;
        //logic
        //check whether we have reached the leaf node
        //preorder
        if(root.left==null && root.right ==null){
            sum+=num*10+root.val;
            return;
        }
        dfs(root.left,num*10+root.val);
        dfs(root.right,num*10+root.val);
    }
}