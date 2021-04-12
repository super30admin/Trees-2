// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> hmap;
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return null;
        hmap = new HashMap<>();
        index = postorder.length - 1;
        // insert all values of inorder in hashmap along with their index to identify
        // their position
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        // crosscheck to not overlap the size of array
        if (start > end)
            return null;
        // initialize root node and increment till size of preorder
        TreeNode root = new TreeNode(postorder[index]);
        // find the position of root in inorder array
        int idx = hmap.get(root.val);
        index--;
        // assign a value for the left and right of root
        root.right = helper(postorder, idx + 1, end);
        root.left = helper(postorder, start, idx - 1);

        return root;
    }
}