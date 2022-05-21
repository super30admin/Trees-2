// Time Complexity : O(N)
// Space Complexity : O(N)
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
    int i; //iterator index
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i=postorder.length-1;
        inorderIndexMap = new HashMap<>();
        for(int index = 0; index < inorder.length; index++) 
            inorderIndexMap.put(inorder[index], index);
        return helper(postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int left, int right) {
        //base
        if(left > right)
            return null;
        //logic
        int rootVal = postorder[i];
        i--;
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, inorderIndexMap.get(rootVal) +1,right);
        root.left = helper(postorder, left, inorderIndexMap.get(rootVal) -1);
        return  root;
    }
}