// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We recursively calculate the left and right node values using both the post and inorder traversal arrays
// 2: The last element in the postorder array is the root and from that we can determine the left and right subtrees
// 3: For each node, we determine the resultant left and right postorder traversal and then recursively calculate
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        return dfs(inorder, postorder);

    }

    private TreeNode dfs(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;

        // find index of root from inorder
        int length = postorder.length;
        int rootVal = postorder[length - 1];
        int idx = findIndex(inorder, rootVal);

        TreeNode root = new TreeNode(rootVal);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, postorder.length - 1);

        root.left = dfs(inLeft, postLeft);
        root.right = dfs(inRight, postRight);

        return root;
    }

    private int findIndex(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal)
                return i;
        }
        return -1;
    }
}