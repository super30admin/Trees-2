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
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int rootIndex = findRootIndex(inorder, root.val);
        int[] leftinorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightinorder = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int[] leftpostorder = Arrays.copyOfRange(postorder, 0, leftinorder.length);
        int[] rightpostorder = Arrays.copyOfRange(postorder, leftinorder.length, leftinorder.length+rightinorder.length);
        root.left = buildTree(leftinorder,leftpostorder);
        root.right = buildTree(rightinorder, rightpostorder);
        return root;
    }
    public int findRootIndex(int[] inorder, int val){
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i]==val) return i;
        }
        return 0;
    }
}