// Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, hashmap is created for storing the inorder values and their indices. Recursive call is used to construct the binary tree with parameters
 * postorder, map and start index and index of root-1 for left sub tree and postorder, map and start root+1 and end for right sub tree. Root is
 * then returned.
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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return helper(postorder, map, 0, inorder.length-1);
    }

    public TreeNode helper(int[] postorder, HashMap<Integer, Integer> map, int start,int end){
        if(start>end) return null;
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(root.val);
        idx--;
        root.right = helper(postorder, map, rootIdx+1, end);
        root.left = helper(postorder, map, start, rootIdx-1);
        
        return root;
    }
}