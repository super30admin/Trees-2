//time-O(n*n)
//Space-O(n*n)
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
        if(postorder.length==0 || inorder.length==0)
        {
            return null;
        }
        int index=-1;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==root.val)
            {
                index=i;
                break;
            }
            
        }
        
        int leftSize=index;
        int preLeft[]=Arrays.copyOfRange(postorder,0,leftSize);
        int inLeft[]=Arrays.copyOfRange(inorder,0,index);
        
        int preRight[]=Arrays.copyOfRange(postorder,leftSize,postorder.length-1);
        int inRight[]=Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        root.left=buildTree(inLeft,preLeft);
        root.right=buildTree(inRight,preRight);
        
        return root;        
        
        
        
    }
}
