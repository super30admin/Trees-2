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
 
 //T(N)=O(N^2)
//S(N)=O(N^2)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0) return null;	//null
        int roIndex=postorder.length-1;
        int rootVal=postorder[roIndex];
        TreeNode root= new TreeNode(rootVal);
        int indx=-1;
        
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)	//Finding and Updating root in inorder
                indx=i;
        }
        int[] inleft=Arrays.copyOfRange(inorder,0,indx);
        int[] inright=Arrays.copyOfRange(inorder,indx+1,inorder.length);
        int[] poright=Arrays.copyOfRange(postorder,roIndex-inright.length,roIndex);
        int[] poleft=Arrays.copyOfRange(postorder,0,roIndex-inright.length);
        
        root.right=buildTree(inright,poright);	//Build Right First
        root.left=buildTree(inleft,poleft);
        
        return root;
        
        
        
        
    }
}