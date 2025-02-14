// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class InPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder);
    }

    private TreeNode helper(int[] inorder, int[] postorder) {
        // base
        if (postorder.length == 0) return null;

        // logic
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, inLeft.length + inRight.length);

        root.left = helper(inLeft, postLeft);
        root.right = helper(inRight, postRight);
        return root;
    }
}
