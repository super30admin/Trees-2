//  Time Complexity: o(n) where n is the number of nodes in the tree
//  Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
//  Did this code successfully run on Leetcode: Yes
//  Any problem you faced while coding this: No 
//  Three line explanation of solution in plain english:
//  1. We recursively find the root of the tree using postorder and inorder arrays.  
//  2. The last element of the postorder array is the root, and we find its index in the inorder array.
//  3. We then split the inorder and postorder arrays into left and right subtrees



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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //check if inorder and postorder arrays are valid
        if (inorder==null || postorder==null || inorder.length==0|| postorder.length==0){
            return null;
        }
        //the last element in the postorder array is the root of the tree
        //we create a new TreeNode with the value of the root
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        if (inorder.length==1){
            return root;
        }
        int rootIdx=-1;
        //we find the index of the root value in the inorder array
        for(int i=0;i<postorder.length;i++){
            if(inorder[i]==root.val){
                 rootIdx=i;
                 break;
            }
        }
        
        //we split the inorder and postorder arrays into left and right subtrees
        //the left subtree is the elements before the root in the inorder array
        int[] inLeft=Arrays.copyOfRange(inorder,0,rootIdx);
        //the left subtree in the postorder array is the elements before the root in the postorder array
        int[] postLeft=Arrays.copyOfRange(postorder,0,rootIdx);
        //the right subtree is the elements after the root in the inorder array
        int[] inRight=Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        //the right subtree in the postorder array is the elements after the left subtree in the postorder array
        int[] postRight=Arrays.copyOfRange(postorder,rootIdx,postorder.length-1);
        //we recursively call the buildTree function for the left and right subtrees
        //this will traverse the tree and build the left and right subtrees
        root.left=buildTree(inLeft,postLeft);
        root.right=buildTree(inRight,postRight);
        return root;
    }
}