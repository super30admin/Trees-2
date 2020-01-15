/*********** Time Complexity: O(n) ************/
/*********** Space Complexity: O(h) ************/


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
        int in_start = 0;
        int in_end = inorder.length-1;
        int post_start = 0;
        int post_end = postorder.length-1;
        
        return buildTree(inorder, in_start, in_end, postorder, post_start, post_end);
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        //base case
        if(inorder == null || postorder == null)
            return null;
            
        //edge cases
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        //last node of postorder array is the root
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        
        for(int i = 0; i < inorder.length ; i++){
            if(inorder[i]==root.val){
                //root = i index
                index = i;
                break;
            }
        }
        
        //  -(inStart+1) to get the length of left subtree in postorder
        root.left = buildTree(inorder, inStart, index - 1, 
                    postorder, postStart, postStart + index - (inStart + 1));
        
        // postStart+k-inStart = postStart+k-(inStart+1) +1
	    root.right = buildTree(inorder, index + 1, inEnd, 
                    postorder, postStart + index- inStart, postEnd - 1);
 
	    return root;
        
    }
}