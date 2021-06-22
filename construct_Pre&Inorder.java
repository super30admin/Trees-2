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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)  return null;
        int rootval=preorder[0];
        TreeNode root=new TreeNode(rootval);
        int rootIdx=0;
        for(int i=0;i<inorder.length;i++)
        {
            if(rootval==inorder[i])
            {
                rootIdx=i;
            }
        }
    
        int [] preleft=Arrays.copyOfRange(preorder,1,rootIdx+1); 
        int [] preright=Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);
        int [] inleft=Arrays.copyOfRange(inorder,0,rootIdx);
        int [] inright=Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        root.left=buildTree(preleft,inleft);
        root.right=buildTree(preright,inright);
        return root;
    }
}