
    /**
    Time Complexity : O(N)
    Explanation:
    - We traverse postorder once.
    - Each node lookup in inorder is O(1) using HashMap.
    So overall linear time.

    Space Complexity : O(N)
    Explanation:
    - HashMap stores inorder indices.
    - Recursion stack can go up to N in worst case (skewed tree).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to split left and right subtrees.
    Later understood:
        - postorder gives root first
        - Inorder gives left | root | right
    Used a global index for preorder and a HashMap to quickly
    find root position in inorder to divide subtrees correctly.
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
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder,int[] postorder) {

        idx = postorder.length-1 ;
        map = new HashMap<>();

        // Store inorder value -> index mapping
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {

        // Base case
        if (start > end) return null;

        // Root from preorder
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);
        idx--;

        // Build left and right subtree
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        
        return root;
    }
}