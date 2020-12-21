/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int count=0;
    public int SumNumbers(TreeNode root) {
        preorder(root,0);
        return count;
        
    }
    
    public void preorder(TreeNode r, int currNumber)
    {
        if(r!=null)
        {
            currNumber = currNumber *10 + r.val;
            if(r.left==null && r.right==null)
            {
                count+=currNumber;
            }
            preorder(r.left,currNumber);
            preorder(r.right,currNumber);
        }
    }
}
