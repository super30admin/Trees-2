/*
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // creating hashmap to store the index of inorder elements

    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap();

        // idx will keep track of postorder elements.

        idx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {

            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {

        // base condition

        if (start > end)
            return null;

        int rootval = postorder[idx];
        idx--;

        // getting the index of eleements

        int rootIdx = map.get(rootval);

        TreeNode root = new TreeNode(rootval);

        root.right = helper(postorder, rootIdx + 1, end);

        root.left = helper(postorder, start, rootIdx - 1);

        return root;

    }
}