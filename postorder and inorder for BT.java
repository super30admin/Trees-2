// Time complexity 0(n^2)
// space complexity 0(n)
// code successfully executed in leetcode.


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
        // edge case
  if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int idx = -1;
      for (int i=0;i < inorder.length;i++){
          if(inorder[i]== root.val){
              idx = i;
              break;
          }
      }
        int [] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int [] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int [] postLeft = Arrays.copyOfRange(postorder,0,idx);
        int [] postRight = Arrays.copyOfRange(postorder,idx,postorder.length-1);
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        return root;
    }
}