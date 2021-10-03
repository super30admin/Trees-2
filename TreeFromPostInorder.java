/*Running time Complexity: O(n)
Space complexity: O(n^2)
Successfully Run and Compiled on leetcode

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
        if(postorder.length==0||inorder.length==0) return null;
        int idx = -1;
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                idx = i;
                break;
            }
        }
        int[] postLeft = Arrays.copyOfRange(postorder,0,idx);
        int[] postRight = Arrays.copyOfRange(postorder,idx,postorder.length-1);
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        return root;
    }
}