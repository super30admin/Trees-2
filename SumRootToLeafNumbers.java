public class SumRootToLeafNumbers {
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
    int total = 0;
    // TC: O(N) where N is length of array
    // SC: O(H) where H is max height of tree
    public int sumNumbers(TreeNode root) {
        // helperWithVoidReturn(root, 0);
        // return total;
        return helperWithIntReturn(root, 0);
    }

    private int helperWithIntReturn(TreeNode root, int currSum) {
        if (root == null) return 0;
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) return currSum;
        return helperWithIntReturn(root.left, currSum) + helperWithIntReturn(root.right, currSum);
    }

    private void helperWithVoidReturn(TreeNode root, int currSum) {
        if (root == null) return;
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += currSum;
        }
        helperWithVoidReturn(root.left, currSum);
        helperWithVoidReturn(root.right, currSum);
    }
}
