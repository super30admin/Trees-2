// 106. Construct Binary Tree from Inorder and Postorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Time Complexity : O(N^2)
// Space Complexity : O(NH)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    Map<Integer, Integer> inorderMap;
    int postIdx;
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(postorder == null || postorder.length == 0)
        return null;
    int n=postorder.length;
    postIdx = n-1;
    inorderMap = new HashMap<>();
    for(int i=0;i<n;i++)
        inorderMap.put(inorder[i],i);
    
    return helper(inorder, postorder, 0, n-1);
}

private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
    // base
    if(start > end) return null;

    // logic
    int rootVal = postorder[postIdx];
    postIdx--;
    TreeNode root = new TreeNode(rootVal);
    
    // find root index in inorder
    int rootIdx = inorderMap.get(rootVal);
    
    root.right = helper(inorder, postorder, rootIdx+1, end);
    root.left = helper(inorder, postorder, start, rootIdx-1);
    
    return root;
}
}