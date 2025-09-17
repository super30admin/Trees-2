// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We take one item at a time from post-order array from the end since that is guranteed to be the next root. Then we use in order array to decide if the current item is in left sub tree or right sub tree.
 */
class Solution {
    int idx;
    Map<Integer, Integer> inOrderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = inorder.length - 1;
        inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        // no more nodes found
        if (start > end)
            return null;

        int rootVal = postorder[idx--];
        int inOrderIdx = inOrderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, inOrderIdx + 1, end);
        root.left = helper(postorder, start, inOrderIdx - 1);

        return root;
    }
}