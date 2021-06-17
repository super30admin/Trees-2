//Time Complexity - O(n^2)
//Space Complexity - O(n^2)


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
   //Brute force solution
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0) return null;
      int rootVal = preorder[0];
      TreeNode root = new TreeNode(rootVal);
      int rootIndex = 0; // index of the root in inoder traversal
      for(int i = 0; i< inorder.length; i++) {
        if(rootVal == inorder[i]) {
          rootIndex = i;
        }
      }
      int [] preLeft = Arrays.copyOfRange(preorder,1, rootIndex + 1);
      int [] preRight = Arrays.copyOfRange(preorder,rootIndex + 1, preorder.length);
      int [] inLeft = Arrays.copyOfRange(inorder,0, rootIndex);
      int [] inRight = Arrays.copyOfRange(inorder,rootIndex+1, inorder.length);
      root.left = buildTree(preLeft, inLeft);
      root.right = buildTree(preRight, inRight);
      return root;
    }
}