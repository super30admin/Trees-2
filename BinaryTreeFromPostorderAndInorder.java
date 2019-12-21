// Time Complexity : O(n)
// Space Complexity : O(1), O(n^2) if recursion stack is considered
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : A little tricky to understand edge cases and indices.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeFromPostorderAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Base case
        if(postorder.length ==0||inorder.length==0){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length -1]);
        int index =-1 ;
        
        for (int i=0; i<inorder.length;i++) {
            if(inorder[i] == root.val) {
                index = i;
                break;
            } 
        }
        
        int [] inLeft = Arrays.copyOfRange(inorder,0,index);
        int [] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int [] postorderRight = Arrays.copyOfRange(postorder, index,postorder.length-1);
        int [] postorderLeft = Arrays.copyOfRange(postorder,0,index);
        
        root.left  = buildTree(inLeft, postorderLeft);
        root.right = buildTree(inRight,postorderRight);
        
        return root;
        
    }
}