// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


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
        if (inorder.length == 0 || postorder.length == 0) {
            return null; 
        }

        int rootVal = postorder[postorder.length-1];

        TreeNode root = new TreeNode(rootVal);
        int rootidx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootidx=i;
            }
        }

        int [] inorderLeft = Arrays.copyOfRange(inorder,0,rootidx);
        int [] inorderRight = Arrays.copyOfRange(inorder,rootidx+1,inorder.length);
        int [] postorderLeft = Arrays.copyOfRange(postorder,0,inorderLeft.length);
        int [] postorderRight = Arrays.copyOfRange(postorder,inorderLeft.length,postorder.length-1);

        root.right = buildTree(inorderRight,postorderRight);
        root.left = buildTree(inorderLeft,postorderLeft);

        return root;




    }
}