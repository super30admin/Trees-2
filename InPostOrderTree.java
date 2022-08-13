// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        if(postorder.length == 0) return null;
        
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int idx = 0;
        for(int i =0;i<inorder.length;i++){
            if(rootVal == inorder[i]){
                idx = i;
                break;
            }
        }
        
        int[] iLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] iRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] pLeft = Arrays.copyOfRange(postorder,0,idx);
        int[] pRight = Arrays.copyOfRange(postorder,idx,postorder.length-1);
        root.left = buildTree(iLeft,pLeft);
        root.right = buildTree(iRight,pRight);
        return root;
        
    }
}
