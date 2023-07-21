// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

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
    // Hashmap to keep track of values and index in inorder array
    Map<Integer, Integer> map;
    // pointer for postorder array
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // postorder pointer will start from n-1
        idx = postorder.length - 1;
        map = new HashMap<>();

        // Putting all elements and it index into hashmap from inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Calling recursive function which will return root node
        return helper(postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int start, int end) {
        // base condition
        if (start > end)
            return null;

        // Get the root value from postorder and decrement postorder pointer
        // Get the index of root in inorder from hashmap

        int rootval = postorder[idx];
        int rootidx = map.get(rootval);
        idx--;
        TreeNode node = new TreeNode(rootval);

        // Left recursion where start would be same and end would be index of root in
        // inorder -1
        // Similarly for right recursion
        node.right = helper(postorder, rootidx + 1, end);
        node.left = helper(postorder, start, rootidx - 1);

        return node;
    }
}