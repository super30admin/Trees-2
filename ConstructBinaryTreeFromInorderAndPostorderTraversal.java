// Time Complexity : O(n), where n is the number of nodes
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


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

    private int postorderIndex;
    private int[] postorder;
    private int[] inorder;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        this.postorder = postorder;
        this.inorder = inorder;
        this.inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1);
    }
        
    private TreeNode buildTree(int inStart, int inEnd){
        // base
        if(inStart > inEnd)
            return null;

        // recursion
        TreeNode node = new TreeNode(postorder[postorderIndex]);
        --postorderIndex;

        int inorderIndex = inorderMap.get(node.val);
        node.right = buildTree(inorderIndex + 1, inEnd);
        node.left = buildTree(inStart, inorderIndex - 1);

        return node;
    }
}