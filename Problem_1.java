// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approch
// Store the tree value(key) and index(value) from the Inorder traversal in a Map, so that while searching for root index, will get in O(1) time. Also initialize the index to length-1 as the root in the Postorder are towards the end.
// Search the root value in Postorder traversal & decrease the index after every call to get the next root.
// Then search the root value in Map to know the root's index. After getting that we will find the desired chunk for that particular recursive call. Always the right recursive calls happen first as in Postorder after the root, right children are there. The start index for right call is rootindex+1 & end index for left call is rootindex-1.


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
    int idx; //index on preorder Arrays

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return helper(postorder, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        //base
        if(start > end)
            return null;

        //logic
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal); //root index in inorder Arrays

        root.right = helper(postorder, inorder, rootIdx+1, end);
        root.left = helper(postorder, inorder, start, rootIdx-1);
        return root;
    }
}
