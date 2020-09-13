    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    Time Complexity for operators : o(n) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(n) ... recursive stack in case of recusrin and normal stack for iterative 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach 

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
              # - Iterative approach
                    A. if we compare arrays of inorder and postorder, we can see that last element of postorder
                       will be the topmost element in the tree. First we will find that first element in inorder array to get the root.
                    B. So by keeping that in mind, we will make a copy's of arrays inLeft, inRight, postLeft, postRight
                    C. store those idexes for calculation, leftsize == index and rightSize = inorder.length-1-index
                    D. inLeft will be from 0 to that of index.
                    E. postLeft will be from 0 to leftSize. next subtrre is required for further interatiopn
                    F. inRight will be from index+1 till the end of inorder array
                    G. postRight also from leftSize till the end of preorder array-1.
       */


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

   class validateBST {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(postorder.length == 0)// || inorder.length ==0)
            return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }
        
        int leftSize = index;
        int rightSize = inorder.length-1-index;
        
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, leftSize);
        
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder,leftSize,postorder.length-1);

        
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        
        return root;
            
    }
}