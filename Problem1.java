// Time complexity: O(n)
// Space complexity: O(n)

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
        // We build the root first
        // We identify the left subtree in both inorder and preorder
        // we identify the right subtree in both inorder and preorder
        // return the root
        if(inorder.length == 0){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val)
                index = i;
        }
        
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] post_left = Arrays.copyOfRange(postorder, 0, index);
        
        int[] in_right = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] post_right = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        // building the left subtree
        root.left = buildTree(in_left, post_left);
        // building the right subtree
        root.right = buildTree(in_right, post_right);
        
        return root;
    }
}
