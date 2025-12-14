// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//The last element in postorder is always the root of the current subtree.
// Use inorder to find the root index, which divides the left and right subtrees.
// Recursively build the right subtree first, then the left, using postorder from the end to the start.
class Solution {
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorder_map = new HashMap<>();
        idx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorder_map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1, inorder_map);
    }

    private TreeNode helper(int[] postorder, int start, int end,
                            HashMap<Integer, Integer> inorder_map) {

        // Base case
        if (start > end) {
            return null;
        }

        // Root comes from postorder (from the end)
        int root_val = postorder[idx--];
        TreeNode root = new TreeNode(root_val);

        int root_idx = inorder_map.get(root_val);

        // IMPORTANT: build right subtree first
        root.right = helper(postorder, root_idx + 1, end, inorder_map);
        root.left = helper(postorder, start, root_idx - 1, inorder_map);

        return root;
    }
}
