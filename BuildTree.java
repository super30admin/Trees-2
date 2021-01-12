// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(h) where h is the heigh of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return getTree(inorder,postorder,postorder.length-1,0,inorder.length-1);

    }

    public TreeNode getTree(int[] inorder, int[] postorder,int postEnd,int inStart,int inEnd){

        // Base case
        if(postEnd < 0 || inStart > inEnd){
            return null;
        }

        // For post order, the root is at the last index
        int val = postorder[postEnd];
        int index = -1;

        // Find root in inorder
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == val){
                index=i;
                break;
            }
        }

        TreeNode root = new TreeNode(val);

        // Partition the array as left child
        root.left = getTree(inorder,postorder,postEnd-1-inEnd+index,inStart,index-1);

        // Partition the array as right child
        root.right = getTree(inorder,postorder,postEnd-1,index+1,inEnd);

        return root;

    }
}