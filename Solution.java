//TC:O(n)
//SC:O(n)
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
        if(postorder.length==0)//base case elements finished
        {
            return null;
        }
        int rootVal=postorder[postorder.length-1];
        int rootIndx=-1;
        TreeNode root=new TreeNode(rootVal);
        for(int i=0;i<inorder.length;i++)
        {
            if(rootVal==inorder[i])
            {
                rootIndx=i;
                break;
            }
        }
        int[] inLeft=Arrays.copyOfRange(inorder,0,rootIndx);//excludes root
        int[] inRight=Arrays.copyOfRange(inorder,rootIndx+1,inorder.length);
        int[] postLeft=Arrays.copyOfRange(postorder,0,inLeft.length);
        int[] postRight=Arrays.copyOfRange(postorder,inLeft.length,postorder.length-1);

    root.left=buildTree(inLeft,postLeft);
    root.right=buildTree(inRight,postRight);
    return root;

        
    }
}