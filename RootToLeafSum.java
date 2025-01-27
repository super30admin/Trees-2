// LC 129
public class RootToLeafSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    /**
     * Void Based recursion using global variable to hold result.
     * TC: O(n)
     * SC: O(h)
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        int[] total = new int[1];
        helper(root, 0, total);
        return total[0];
    }

    private void helper(TreeNode root, int num, int[] total) {
        // base
        // NOTE: hitting a nul != hitting a leaf node
        if (root == null) {
            return;
        }
        // accumulate the number
        num = num * 10 + root.val;
        // hit the required case for a leaf node
        if (isLeaf(root)) {
            total[0] += num;
            return;
        }
        // preorder traversal
        helper(root.left, num, total);
        helper(root.right, num, total);
    }

    /**
     * Int Based recursion:
     * Root
     * /  \
     * Root to Left Path  +  Root to Right Path
     * <p>
     * Find the root to leaf path num.
     * Total = Left Path Num + Right Path Num
     * <p>
     * TC: O(n)
     * SC: O(h)
     *
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        // base
        // NOTE: hitting a null != hitting a leaf node
        if (root == null) {
            return 0;
        }
        // accumulate the number
        num = num * 10 + root.val;
        // hit the required case for a leaf node
        if (isLeaf(root)) {
            return num;
        }
        // preorder traversal
        int left = helper(root.left, num);
        int right = helper(root.right, num);
        return left + right;
    }
}
