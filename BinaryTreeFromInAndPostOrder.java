// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/**
 * Using HashMap storing the numbers and its index of inorder array
 * for post order root is at end, so root->right-> left
 * based on that identifying the start and end for traversing right and left sub tree
 */

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
    HashMap<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }
        //logic
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);

        int rtIdx = map.get(rootVal);
        index--;



        root.right = helper(postorder, rtIdx+1, end);
        root.left = helper(postorder, start, rtIdx-1);

        return root;
    }
}