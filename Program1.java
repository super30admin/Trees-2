//Time Complexity : O(m+n)
//Space Complexity : O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder.length==0){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index=-1;
        for(int i=0; i<inorder.length;i++){
            if(root.val==inorder[i]){
                index=i;
            }
        }
        
        int[] in_left = Arrays.copyOfRange(inorder,0,index);
        int[] post_left = Arrays.copyOfRange(postorder,0,index);
        
        int[] in_right=Arrays.copyOfRange(inorder, index+1,inorder.length);
        int[] post_right=Arrays.copyOfRange(postorder,index,postorder.length-1);
        
        root.left=buildTree(in_left,post_left);
        root.right=buildTree(in_right,post_right);
        
        return root;
        
    }
}