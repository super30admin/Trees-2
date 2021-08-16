// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        idx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] postorder, int start, int end){
        //base
        if(start > end){
            return null;
        }
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        return root;
    }
}