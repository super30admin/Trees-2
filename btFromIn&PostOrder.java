// Time Complexity : O(n)
// Space Complexity : O(n) + O(h)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/*
 * Reduce the search space complexity by creating a map , and ans to using a 2 pointer apporach to generate the left and right subtree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map;
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        index = postorder.length - 1;
        // map to add the indexes of the nodes in inorder array
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1, -1);
    }

    private TreeNode helper(int[] postorder, int start, int end, int rootIdx) {
        // base
        if (start > end)
            return null;

        // logic

        // get the root node from postorder array
        int rootVal = postorder[index];

        index--;
        rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // left and right recursive call
        root.right = helper(postorder, rootIdx + 1, end, rootIdx);
        root.left = helper(postorder, start, rootIdx - 1, rootIdx);

        return root;
    }
}