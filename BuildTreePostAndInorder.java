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
        //edge
        if(postorder == null || postorder.length == 0){
            return null;
        }
        
        //declaring root node 
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = -1;
        
        //iterating for root value index in inorder
        for(int i = 0; i < inorder.length; i++){
            if(root.val == inorder[i]){
                index = i;
                break;
            }
        }
        
        //postorder
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length -1);
        
        //Inorder
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        //building left and right sub trees
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        //returning root
        return root;
    }
}

// n --> number of nodes
//Time Complexity: O(n)
//space Complexity: O(n)