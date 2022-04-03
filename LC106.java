//Time Complexity : O(N)
//Space Complexity : O(N)

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
        if(postorder==null | postorder.length==0)
        {
            return null;
        }
        
        int rootval = postorder[postorder.length-1];
        
        TreeNode root = new TreeNode(rootval);
        
        int rootIdx = 0;
        
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootval)
            {
                rootIdx = i;    
            }
        }
        
        int inorder_left[] = Arrays.copyOfRange(inorder,0,rootIdx);
        int inorder_right[] = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int postorder_left[] = Arrays.copyOfRange(postorder,0,rootIdx);
        int postorder_right[] = Arrays.copyOfRange(postorder,rootIdx,postorder.length-1);
        
        root.left = buildTree(inorder_left,postorder_left);
        root.right = buildTree(inorder_right,postorder_right);
        
        return root;
    }
}