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
    int counter=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder,postorder,0,n,0,n);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int i1, int i2, int p1, int p2){        
        if(i1 >= i2 || p1 >= p2){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[p2-1]);
        int index=0;
        for(int i=i1;i<i2;i++){
            if(postorder[p2-1] == inorder[i]){
                index=i;
                break;
            }
        }
        int diff = index - i1;
        root.left = helper(inorder,postorder,i1,i1+diff,p1,p1+diff);
        root.right = helper(inorder,postorder,i1+diff+1,i2,p1+diff,p2-1);
        
        return root;
    }
    
}