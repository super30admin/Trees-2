//Time-O(n)
//Space-O(n)-Recursive stack in consideration
//Had the iterative approach using string but found this better 
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
    private int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        recurr(root,0);
        return sum;
    }
    
    public void recurr(TreeNode root, int curr)
    {
        if(root==null)
        {
            return;
        }
        curr=curr*10+root.val;
        if(root.left==null && root.right==null)
        {
            sum=sum+curr;
            return;
        }
        recurr(root.left,curr);
        recurr(root.right,curr);
        
    }
}
