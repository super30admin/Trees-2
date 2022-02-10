public class SumRoot {
    int rootSum = 0;

    public int sumRoot(TreeNode root) {

        return rootSum;
    }

    public void helper(TreeNode root, int currSum) {
        if (root != null) {
            currSum = currSum * 10 + root.val;

            if (root.left == null && root.right == null) {
                rootSum += currSum;
            }
            helper(root.left, currSum);
            helper(root.right, currSum);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode prev;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right, TreeNode prev) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.prev = prev;
        }
    }
}
