// Time Complexity : o(n) where n is the length of the preorder or inorder array
// Space Complexity : o(n) 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
    /* The last element of the post-order gives the root element.
    Find the root element in inorder. Left of the root would give us the length of the elements in the left subtree and right of the root 
    will give the length of the elements of the right subtree.
    Divide the postorder acooring to the length obtained and take just the left and right parts separately as a subproblem. 
    in postorder: The left side last element would be root again for the left subtree and right side last element in preorder would be the root for the 
    right sub tree.
    Repeat the process by finding the root each time in inorder and calculating the left and right subtrees.
*/
// Your code here along with comments explaining your approach





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
class BTFromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length ==0){
            return null;
        }
        //The last element of the pre-order gives the root element.
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = postorder.length-1;
        //Finding the root element in the inorder
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        //dividing the pre-orer and in-order into left and rigth subtrees according to the index of the root element found
        int[] leftPost = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPost = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        int[] rightIn = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        //making a recursive call to the left and right subtrees
        root.left = buildTree(leftIn, leftPost);
        root.right = buildTree(rightIn, rightPost);
        
        return root;
        
    }
}