/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Time Complexity : O(N^2)
Space Complexity : O(N)
The idea is to pick last node as root in postorder traversal and then locate the element in inorder to identify left sub tree and right subtree till we traverse  all elements
**/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
        //Boundary Class
        if(postorder == null || postorder.length < 1)
            return null;
        
        if(inorder == null || inorder.length < 1)
            return null;
        
        //Find root node 
        TreeNode node  = new TreeNode(postorder[postorder.length - 1]);
        int root_index = -1; 
        
        for(int i = 0; i < inorder.length; i++){
            if(node.val == inorder[i]){
                root_index   =  i;
                break;
            }
            
        
        }
        
            //leftOrder Inorder Sub Tree
            int[] leftInorderTree   = Arrays.copyOfRange(inorder,0,root_index);
            
             //rightOrder Inorder Sub Tree
            int[] rightInorderTree  = Arrays.copyOfRange(inorder, root_index + 1, inorder.length);
        
            //leftOrder PreOrder Sub Tree
            int[] leftPostorderTree  = Arrays.copyOfRange(postorder,0,root_index);
            
            //rightOrder PreOrder Sub Tree
            int[] rightPostorderTree = Arrays.copyOfRange(postorder,root_index, postorder.length - 1);
        
            //Build Subtree
            node.left  = buildTree(leftInorderTree,leftPostorderTree);
            node.right = buildTree(rightInorderTree,rightPostorderTree);
            
            return node;
        
    }
}
