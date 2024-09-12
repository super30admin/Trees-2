/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm:
    1. Post order is left-right-root and inorder is left-root-right
    2, From the post order traversal get the root value, from the inorder array get the index of the root.
    3. Left of inorder is  the left subtree and right of inorder is right subtree, based on this form the tree by knowing the left and subtree from post order.
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Did the code run successfully on leetcode? Yes

*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0 || inorder.length==0)
            return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index=0;
        for(int i=0; i<inorder.length; i++){
            if(root.val==inorder[i]){
                index=i;
                break;
            }
        }
        
        int[] postLeft = Arrays.copyOfRange(postorder, 0 , index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length-1);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(inorderLeft, postLeft);
        root.right = buildTree(inorderRight, postRight);
        
        return root;
    }
}