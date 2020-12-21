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
    int postindx;
    Dictionary<int,int> dict = new Dictionary<int,int>();
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        
        postindx = postorder.Length-1;
        int idx =0;
        foreach(int i in inorder)
        {
            dict.Add(i,idx++);
        }
        return helper(0,inorder.Length-1,inorder,postorder);
    }
    
    private TreeNode helper(int left,int right,int[] inorder,int[] postorder)
    {
     if(left>right)
     {
         return null;
     }
        int rootval = postorder[postindx];
        TreeNode root = new TreeNode(rootval);
        
        int index = dict[rootval];
        
        postindx--;
        root.right = helper(index+1,right,inorder,postorder);
        
        root.left = helper(left,index-1,inorder,postorder);
        return root;
    }
}
